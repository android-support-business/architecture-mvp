package com.amlzq.android.architecture;

/**
 * Created by amlzq on 2018/9/26.
 * 列表视图
 * from liuxuancai
 */

public interface BaseListView<T extends BasePresenter> extends BaseView {

    void loadMoreEnd();

    void loadMoreComplete();

    void loadMoreFail();

}
