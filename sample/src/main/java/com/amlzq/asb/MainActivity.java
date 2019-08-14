package com.amlzq.asb;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.amlzq.android.architecture.schedulers.AppExecutors;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        MainFragment fragment = MainFragment.newInstance();
        new MainPresenter(fragment, new AppExecutors());
        transaction.add(R.id.fragment_container, fragment);
        transaction.commit();
    }

}
