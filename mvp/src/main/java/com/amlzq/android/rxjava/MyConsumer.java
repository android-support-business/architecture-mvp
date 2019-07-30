package com.amlzq.android.rxjava;

import io.reactivex.functions.Consumer;

/**
 * https://www.jianshu.com/p/5b8b1062866b
 * Retrofit自定义GsonConverter处理所有请求错误情况
 *
 * @param <T>
 */
public class MyConsumer<T> implements Consumer<T> {

    @Override
    public void accept(T t) throws Exception {

    }

    public void accept(Throwable throwable) throws Exception {

    }

}
