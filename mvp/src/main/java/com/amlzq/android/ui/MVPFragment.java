package com.amlzq.android.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.architecture.BasePresenter;
import com.amlzq.android.architecture.BaseView;
import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * base mvp fragment
 *
 */
public abstract class MVPFragment<P extends BasePresenter>
        extends BaseFragment
        implements BaseView<P> {

    // 视图注解
    protected Unbinder mUnbinder;
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        RxBus.get().register(this);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showLoadingError(String msg) {

    }

    @Override
    public boolean isActive() {
        return isAlive(mUniqueTag);
    }

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

}
