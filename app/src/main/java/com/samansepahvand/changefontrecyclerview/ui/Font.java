package com.samansepahvand.changefontrecyclerview.ui;

import android.app.Application;

import com.samansepahvand.changefontrecyclerview.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Font extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/estedad.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}

