package com.amlzq.asb;


import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;

import com.amlzq.android.app.BaseFragment;
import com.jakewharton.rxbinding2.view.RxView;
import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * 权限
 */
public class PermissionsFragment extends BaseFragment {
    public static final String TAG = "PermissionsFragment";

    public PermissionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PermissionsFragment.
     */
    public static PermissionsFragment newInstance() {
        PermissionsFragment fragment = new PermissionsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_permissions;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void afterCreate(Bundle bundle) {

        final RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions.request(Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE)
                .subscribe(granted -> {
                    if (granted) {
                        // All requested permissions are granted
                    } else {
                        // At least one permission is denied
                    }
                });

        // Must be done during an initialization phase like onCreate
        RxView.clicks(findViewById(R.id.btn_action))
                .compose(rxPermissions.ensure(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_PHONE_STATE))
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
                        // I can control the camera now
                        showToastShort("通过");
                    } else {
                        // Oups permission denied
                        showToastShort("未通过");
                    }
                });

        rxPermissions.requestEach(Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE)
                .subscribe(permission -> { // will emit 2 Permission objects
                    if (permission.granted) {
                        // `permission.name` is granted !
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // Denied permission without ask never again
                    } else {
                        // Denied permission with ask never again
                        // Need to go to the settings
                    }
                });

        rxPermissions.requestEachCombined(Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE)
                .subscribe(permission -> { // will emit 1 Permission object
                    if (permission.granted) {
                        // All permissions are granted !
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // At least one denied permission without ask never again
                    } else {
                        // At least one denied permission with ask never again
                        // Need to go to the settings
                    }
                });


    }

}
