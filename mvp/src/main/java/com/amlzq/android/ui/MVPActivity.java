package com.amlzq.android.ui;

import android.os.Bundle;

import com.amlzq.android.app.BaseActivity;
import com.hwangjr.rxbus.RxBus;

/**
 * base mvp activity
 * butter knife
 * rxbus
 * state view
 *
 */
public abstract class MVPActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }


}
