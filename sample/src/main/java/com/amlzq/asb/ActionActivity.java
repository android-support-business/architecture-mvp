package com.amlzq.asb;

import android.os.Bundle;

import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.app.BaseFragmentActivity;

public class ActionActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        startFragment(mTargetFragmentTag);
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

    @Override
    protected BaseFragment fragmentProvider(String fragmentTag, String... args) {
        if (PermissionsFragment.TAG.equals(fragmentTag)) {
            PermissionsFragment fragment = PermissionsFragment.newInstance();
            return fragment;
        } else {
            return super.fragmentProvider(fragmentTag, args);
        }
    }

}
