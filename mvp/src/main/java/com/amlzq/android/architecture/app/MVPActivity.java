<<<<<<< HEAD:mvp/src/main/java/com/amlzq/android/ui/MVPActivity.java
package com.amlzq.android.ui;
=======
package com.amlzq.android.architecture.app;
>>>>>>> 1acebe7068583c08cdcb74267001fbf6328483da:mvp/src/main/java/com/amlzq/android/architecture/app/MVPActivity.java

import android.os.Bundle;

import com.amlzq.android.app.BaseActivity;
import com.hwangjr.rxbus.RxBus;

<<<<<<< HEAD:mvp/src/main/java/com/amlzq/android/ui/MVPActivity.java
/**
 * base mvp activity
 * butter knife
 * rxbus
 * state view
 *
 */
public abstract class MVPActivity extends BaseActivity {
=======
public class MVPActivity extends BaseActivity {
>>>>>>> 1acebe7068583c08cdcb74267001fbf6328483da:mvp/src/main/java/com/amlzq/android/architecture/app/MVPActivity.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }


}
