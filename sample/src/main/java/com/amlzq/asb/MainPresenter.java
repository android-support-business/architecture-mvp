package com.amlzq.asb;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.amlzq.android.architecture.schedulers.AppExecutors;

/**
 * 主理人
 */
public class MainPresenter implements MainContract.Presenter {

    @NonNull
    private final MainContract.View mView;
    @NonNull
    private final AppExecutors mAppExecutors;

    public MainPresenter(@NonNull MainContract.View view,
                         @NonNull AppExecutors appExecutors) {
        mView = view;
        mAppExecutors = appExecutors;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void result(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void destroy() {

    }

    private void loadData() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

}
