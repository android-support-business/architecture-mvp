package com.amlzq.asb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {
    public static final String TAG = "HomeFragment";

    @BindView(R.id.tv_info)
    TextView mTVInfo;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        ButterKnife.bind(this, mContentView);

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @SuppressLint("CheckResult")
    @OnClick(R.id.btn_action)
    public void onActionEvent(View view) {
//        Intent intent = new Intent()

        //创建被观察者
        Observable.create(new ObservableOnSubscribe<String>() {

            //默认在主线程里执行该方法
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Log.d(this);
                e.onNext("俊俊俊很帅");
                e.onNext("你值得拥有");
                e.onNext("取消关注");
                e.onNext("但还是要保持微笑");
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())//将被观察者切换到子线程
                .observeOn(AndroidSchedulers.mainThread())//将观察者切换到主线程
                .subscribe(new Observer<String>() {//创建观察者并订阅

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(d.isDisposed());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(this);
                    }
                });

    }

    @OnClick(R.id.btn_permission)
    public void onPermissionsEvent(View view) {
        Intent intent = new Intent(mContext, ActionActivity.class);
        intent.putExtra(ActivityUtil.FRAGMENT_TAG, PermissionsFragment.TAG);
        startActivity(intent);
    }

    @OnClick(R.id.btn_search)
    public void onSearchEvent(View view) {

    }

    @OnClick(R.id.btn_rxbinding)
    public void onRxBindingEvent(View view) {

    }

}
