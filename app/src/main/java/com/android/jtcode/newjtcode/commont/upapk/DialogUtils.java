package com.android.jtcode.newjtcode.commont.upapk;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.android.jtcode.newjtcode.R;

/**
 * Created by Gu FanFan.
 * Date: 2017/4/13, 11:45.
 * 对话框utils.
 */

public class DialogUtils {

    private static Dialog createDialog(Context context, int layoutId, int themeId) {
        View view = View.inflate(context, layoutId, null);
        Dialog dialog;
        dialog = new Dialog(context, themeId);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        return dialog;
    }

    public static Dialog startDownloadDialog(Context context) {
        return createDialog(context, R.layout.layout_download_loading, R.style.CustomDialog);
    }
}
