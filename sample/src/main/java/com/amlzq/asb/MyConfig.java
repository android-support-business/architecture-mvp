package com.amlzq.asb;

import android.content.Context;

import com.amlzq.android.ApplicationConfig;
import com.amlzq.android.util.UtilConfig;

/**
 * 配置
 */
public class MyConfig extends ApplicationConfig {

    public static void configApplication(Context context) {
        UtilConfig.DEBUG = BuildConfig.DEBUG;
        UtilConfig.init(context, IDENTIFY);
    }

}
