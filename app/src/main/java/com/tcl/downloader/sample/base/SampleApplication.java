package com.tcl.downloader.sample.base;

import org.aisen.android.common.context.GlobalContext;
import org.aisen.android.common.utils.Logger;
import org.aisen.android.component.bitmaploader.BitmapLoader;
import org.aisen.downloader.DownloadManager;

/**
 * Created by wangdan on 16/5/7.
 */
public class SampleApplication extends GlobalContext {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.DEBUG = true;

        BitmapLoader.newInstance(this, String.valueOf(getExternalFilesDir("images")));

        new DownloadManager.Builder(this).setDebug(true).build();
        org.aisen.download.DownloadManager.setup(this, true, 2);
    }

}
