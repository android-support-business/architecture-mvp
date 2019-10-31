package com.amlzq.android.architecture.app;

import android.os.Bundle;

import com.amlzq.android.app.BaseActivity;
import com.hwangjr.rxbus.RxBus;

public class MVPActivity extends BaseActivity {

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
