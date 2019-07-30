package com.amlzq.asb;

import android.app.Activity;
import android.os.Bundle;

import com.amlzq.android.architecture.BaseListView;
import com.amlzq.android.architecture.BasePresenter;

public class MainActivity extends Activity implements BaseListView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void loadMoreEnd() {

    }

    @Override
    public void loadMoreComplete() {

    }

    @Override
    public void loadMoreFail() {

    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showLoadingError(String message) {

    }
}
