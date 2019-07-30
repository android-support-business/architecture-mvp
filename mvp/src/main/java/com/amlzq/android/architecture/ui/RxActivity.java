package com.amlzq.android.architecture.ui;

import android.os.Bundle;

import com.amlzq.android.app.BaseActivity;
import com.hwangjr.rxbus.RxBus;

public class RxActivity extends BaseActivity {

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
