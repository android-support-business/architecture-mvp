package com.amlzq.asb;

import android.app.Application;
import android.content.Context;

import com.amlzq.android.ApplicationConfig;
import com.amlzq.android.content.ContextHolder;
import com.amlzq.android.content.res.RUtil;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.DisplayUtil;
import com.amlzq.android.util.Logger;

import com.amlzq.android.ApplicationConfig;
import com.amlzq.android.log.Log;
import com.amlzq.android.log.LogWrapper;
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
    public static String IDENTIFY = "MVP-Plus";
    /**
     * 调试开关
     */
    public static boolean DEBUG = false;

    public static void configApplication(Application application) {
        // 项目标识
        ApplicationConfig.IDENTIFY = IDENTIFY;
        // 调试开关
        ApplicationConfig.DEBUG = BuildConfig.DEBUG;
        // SharedPreferences File Name
        ApplicationConfig.SHARED_PREFERENCES_NAME = IDENTIFY + "Prefs";

        // 初始化工具库
        UtilConfig.DEBUG = DEBUG;
        UtilConfig.init(application, IDENTIFY);

        // 初始化日志库
        Log.TAG = IDENTIFY;
        Log.LEVEL = Log.VERBOSE;
        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);
    }

}