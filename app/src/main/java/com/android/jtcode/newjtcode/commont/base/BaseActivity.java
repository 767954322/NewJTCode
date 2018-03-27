package com.android.jtcode.newjtcode.commont.base;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.android.jtcode.newjtcode.R;
import com.android.jtcode.newjtcode.commont.baseutils.ActivityManager;
import com.android.jtcode.newjtcode.jtutils.UIUtils;
import com.jaeger.library.StatusBarUtil;


public abstract class BaseActivity extends FragmentActivity {
    private boolean destroyed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutResId());
        ActivityManager.getInstance().addActivity(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().setBackgroundDrawableResource(R.mipmap.window_bg);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            StatusBarUtil.setColor(this, UIUtils.getColor(R.color.white),0);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }else {
            StatusBarUtil.setColor(this, UIUtils.getColor(R.color.black),0);
        }
        initExtraBundle();
        initView();
        initData(savedInstanceState);
        initListener();
//        StatusBarUtil.setTranslucentForImageView(this, 0, null);

    }
    /**
     * 获取布局的Id
     *
     */
    protected abstract int getLayoutResId();

    /**
     * 查找控件
     */
    protected abstract void initView();

    /**
     * 获取bundle数据
     */
    protected void initExtraBundle() {
    }

    /**
     * 初始化数据操作
     *
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 设置监听
     */
    protected void initListener() {
    }

    public boolean isDestroyed() {
        return destroyed;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
    }


    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

}
