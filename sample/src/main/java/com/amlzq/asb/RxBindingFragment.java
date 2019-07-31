package com.amlzq.asb;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import com.amlzq.android.app.BaseFragment;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

/**
 * 演示RxBinding
 */
public class RxBindingFragment extends BaseFragment {
    public static final String TAG = "RxBindingFragment";

    // 测试按钮防抖
    Button mBtnBounce;

    public RxBindingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RxBindingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RxBindingFragment newInstance() {
        RxBindingFragment fragment = new RxBindingFragment();
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
        return R.layout.fragment_rx_binding;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void afterCreate(Bundle bundle) {

        RxView.clicks(findViewById(R.id.btn_bounce))
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        showToastShort("按钮被点击了");
                    }
                });
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}
