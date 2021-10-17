package com.amlzq.asb;

import android.app.Application;
import android.content.Context;

import com.amlzq.android.ApplicationConfig;
import com.amlzq.android.content.ContextHolder;
import com.amlzq.android.content.res.RUtil;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.DisplayUtil;
import com.amlzq.android.util.Logger;
import com.amlzq.android.util.UtilConfig;

/**
 * 配置
 */
public class MyConfig extends ApplicationConfig {

    /**
     * 应用程序标识
     */
    public static String IDENTIFY = "MVP+";
    /**
     * 调试开关
     */
    public static boolean DEBUG = true;

    public static void configApplication(Application thisApp) {
        ApplicationConfig.IDENTIFY = IDENTIFY;
        ApplicationConfig.DEBUG = DEBUG;

        Log.TAG = IDENTIFY;
        Log.LEVEL = DEBUG ? android.util.Log.VERBOSE : android.util.Log.INFO;

        ContextHolder.init(thisApp);

        RUtil.init(thisApp);
        DisplayUtil.init(thisApp);
    }

}
