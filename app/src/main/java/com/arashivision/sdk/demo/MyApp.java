package com.arashivision.sdk.demo;

import android.app.Application;

import com.arashivision.sdk.demo.activity.StitchActivity;
import com.arashivision.sdk.demo.util.AssetsUtil;
import com.arashivision.sdkcamera.InstaCameraSDK;
import com.arashivision.sdkmedia.InstaMediaSDK;

import java.io.File;

public class MyApp extends Application {

    private static MyApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        // Init SDK
        InstaCameraSDK.init(this);
        InstaMediaSDK.init(this);

        // Copy sample pictures from assets to local
        copyHdrSourceFromAssets();
    }

    private void copyHdrSourceFromAssets() {
        File dirHdr = new File(StitchActivity.HDR_COPY_DIR);
        if (!dirHdr.exists()) {
            AssetsUtil.copyFilesFromAssets(this, "hdr_source", dirHdr.getAbsolutePath());
        }

        File dirPureShot = new File(StitchActivity.PURE_SHOT_COPY_DIR);
        if (!dirPureShot.exists()) {
            AssetsUtil.copyFilesFromAssets(this, "pure_shot_source", dirPureShot.getAbsolutePath());
        }
    }

    public static MyApp getInstance() {
        return sInstance;
    }

}