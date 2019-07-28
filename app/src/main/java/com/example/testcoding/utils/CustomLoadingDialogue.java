package com.example.testcoding.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.example.testcoding.R;

public class CustomLoadingDialogue extends Dialog{
    private Activity mContext;

    public CustomLoadingDialogue(Context context) {
        super(context);
        mContext = (Activity) context;
        init();
    }

    private void init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_loading_dialogue);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

       /* circularProgressBar = findViewById(R.id.pg_circular);
        circularProgressBar.setProgressWithAnimation(0);
        circularProgressBar.enableIndeterminateMode(true);*/

        setCancelable(false);
    }
}
