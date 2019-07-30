package com.amlzq.asb;

import android.os.Bundle;

import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.app.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFragment(HomeFragment.TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

    @Override
    protected BaseFragment fragmentProvider(String fragmentTag, String... args) {
        if (fragmentTag.equals(HomeFragment.TAG)) {
            HomeFragment fragment = HomeFragment.newInstance();
            return fragment;
        } else {
            return super.fragmentProvider(fragmentTag, args);
        }
    }

}
