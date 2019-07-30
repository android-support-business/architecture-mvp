package com.amlzq.asb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import com.amlzq.android.app.BaseFragment;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 搜索示例
 */
public class SearchFragment extends BaseFragment {
    public static final String TAG = "SearchFragment";

    // 输入框
    EditText mETInput;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_search;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void afterCreate(Bundle bundle) {

        RxTextView.textChanges(findViewById(R.id.et_input))
                // 当你敲完字之后停下来的半秒就会执行下面语句
                .debounce(500, TimeUnit.MILLISECONDS)
                // 下面这两个都是数据转换
                // flatMap：当同时多个网络请求访问的时候，前面的网络数据会覆盖后面的网络数据
                // switchMap：当同时多个网络请求访问的时候，会以最后一个发送请求为准，前面网路数据会被最后一个覆盖
                .switchMap(new Function<CharSequence, ObservableSource<List<String>>>() {
                    @Override
                    public ObservableSource<List<String>> apply(@NonNull CharSequence charSequence) throws Exception {
                        //网络操作，获取我们需要的数据
                        List<String> list = new ArrayList<String>();
                        list.add("2017年款最新帅哥俊俊俊");
                        list.add("找不到2017年比俊俊俊更帅的人");
                        return Observable.just(list);
                    }
                })
                // 网络请求是在子线程的
                .subscribeOn(Schedulers.io())
                // 界面更新在主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(@NonNull List<String> strings) throws Exception {
                        // 界面更新，这里用打印替代
                        System.out.println(strings.toString());
                    }
                });
    }


}
