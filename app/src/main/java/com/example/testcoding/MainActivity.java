package com.example.testcoding;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testcoding.model.ImagesItemModel;
import com.example.testcoding.roomdb.dbtables.RetroImagesTable;
import com.example.testcoding.roomdb.dbviewmodels.RoomViewModel;
import com.example.testcoding.utils.CustomLoadingDialogue;
import com.example.testcoding.utils.Utility;
import com.example.testcoding.viewmodels.RetroImagesViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    RetroImagesViewModel imagesViewModel;
    List<ImagesItemModel> imagesItemList;
    private CustomLoadingDialogue customLoadingDialogue;
    private TableLayout tableLayout;
    private RoomViewModel roomViewModel;
    TableRow tableRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        intializeViewsAndObjects();
    }

    private void intializeViewsAndObjects() {
        tableLayout = findViewById(R.id.imagesTable);
        customLoadingDialogue = new CustomLoadingDialogue(mContext);
        imagesItemList = new ArrayList<>();

        roomViewModel = ViewModelProviders.of(MainActivity.this).get(RoomViewModel.class);
        imagesViewModel = ViewModelProviders.of(MainActivity.this).get(RetroImagesViewModel.class);
        imagesViewModel.inIT();
        if (Utility.isNetworkAvailable(mContext)){
            showLoadingDialogue();
            getNetworkReqData();
        }else {
            getRoomImagesData();
        }
    }
    private void getNetworkReqData(){
        imagesViewModel.getAllImages().observe(MainActivity.this, new Observer<List<ImagesItemModel>>() {
            @Override
            public void onChanged(@Nullable List<ImagesItemModel> imagesItemModelList) {
                imagesItemList = imagesItemModelList;
                hideLoadingDialogue();
                if (imagesItemList !=null && imagesItemList.size()>0){
                    if (roomViewModel!=null){
                        insertImagesTODb(imagesItemList);
                    }
                    fillTableView();
                }else {
                    hideLoadingDialogue();
                }
            }
        });
    }
    private void fillTableView() {
        TableRow rowHeader = new TableRow(mContext);
        rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText={"ID","TITLE","URL"};
        for(String c:headerText) {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            rowHeader.addView(tv);
        }
        tableLayout.addView(rowHeader);
        for (int i = 0; i < imagesItemList.size(); i++) {
            tableRow = new TableRow(mContext);
            String id = imagesItemList.get(i).getId();
            String title = imagesItemList.get(i).getTitle();
            String thumbnailUrl = imagesItemList.get(i).getThumbnailUrl();
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            String[] colText = {id,title,thumbnailUrl};
            for (String text:colText){
                TextView tv = new TextView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(100, 150);
                tv.setLayoutParams(layoutParams);
                tv.setSingleLine(false);
                tv.setGravity(Gravity.CENTER);
                tv.setEllipsize(TextUtils.TruncateAt.END);
                tv.setLines(2);
                tv.setTextSize(16);
                tv.setPadding(5, 5, 5, 5);
                tv.setText(text);
                tableRow.addView(tv);
            }
            tableLayout.addView(tableRow);

        }

    }
    public void insertImagesTODb(List<ImagesItemModel> imagesList){
        try {
            if (imagesList.size() > 0) {
                for (ImagesItemModel imagesItemModel : imagesList) {
                    RetroImagesTable retroImagesTable = new RetroImagesTable();
                    retroImagesTable.setAlbumId(imagesItemModel.getAlbumID());
                    retroImagesTable.setID(imagesItemModel.getId());
                    retroImagesTable.setThumbnailUrl(imagesItemModel.getThumbnailUrl());
                    retroImagesTable.setTitle(imagesItemModel.getTitle());
                    retroImagesTable.setUrlImages(imagesItemModel.getImageUrl());
                    roomViewModel.insertAllImages(retroImagesTable);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void getRoomImagesData(){
        roomViewModel.getAllImages().observe((LifecycleOwner) mContext, new Observer<List<RetroImagesTable>>() {
            @Override
            public void onChanged(@Nullable List<RetroImagesTable> retroImagesTables) {
                if (retroImagesTables!=null && retroImagesTables.size()>0){
                    for (int i = 0; i <retroImagesTables.size() ; i++) {
                        ImagesItemModel imagesItemModel = new ImagesItemModel();
                        imagesItemModel.setAlbumID(retroImagesTables.get(i).getAlbumId());
                        imagesItemModel.setId(retroImagesTables.get(i).getID());
                        imagesItemModel.setImageUrl(retroImagesTables.get(i).getUrlImages());
                        imagesItemModel.setTitle(retroImagesTables.get(i).getTitle());
                        imagesItemModel.setThumbnailUrl(retroImagesTables.get(i).getThumbnailUrl());
                        imagesItemList.add(imagesItemModel);
                    }
                    fillTableView();
                }else {
                    Toast.makeText(mContext,"please connect to internet",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void showLoadingDialogue() {
        if (customLoadingDialogue != null && !customLoadingDialogue.isShowing()) {
            customLoadingDialogue.show();
        }
    }

    private void hideLoadingDialogue() {
        if (customLoadingDialogue != null && customLoadingDialogue.isShowing()) {
            customLoadingDialogue.dismiss();
        }
    }
}
