package com.homechart.app;

import android.os.Build;
import android.os.StrictMode;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import android.support.multidex.MultiDexApplication;

/**
 * Created by gumenghao on 17/5/17.
 */

public class MyApplication extends MultiDexApplication {

    private static MyApplication myApplication;
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        myApplication = this;
        queue = Volley.newRequestQueue(this);
    }

    public static synchronized MyApplication getInstance() {
        if (myApplication == null) {
            myApplication = new MyApplication();
        }
        return myApplication;
    }
}
