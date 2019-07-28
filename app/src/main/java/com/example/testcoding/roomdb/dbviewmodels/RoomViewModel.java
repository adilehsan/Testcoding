package com.example.testcoding.roomdb.dbviewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.testcoding.roomdb.dbrepository.ImagesDbRepository;
import com.example.testcoding.roomdb.dbtables.RetroImagesTable;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {

    private ImagesDbRepository imagesDbRepository;
    private LiveData<List<RetroImagesTable>> mAllImages;

    public RoomViewModel(Application application){
        super(application);
        imagesDbRepository = new ImagesDbRepository(application);
        mAllImages = imagesDbRepository.getAllImages();
    }

    public LiveData<List<RetroImagesTable>> getAllImages() { return mAllImages; }

    public void insertAllImages(RetroImagesTable retroImagesTable) {
        imagesDbRepository.insertAllImages(retroImagesTable); }
}
