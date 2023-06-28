package com.wemakebest.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class CommonFunctions {

    public static Dialog loadingDialog;

    public static void showLoading(Context context) {
        loadingDialog = new Dialog(context);
        loadingDialog.setContentView(R.layout.dlg_loading);
        loadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
    }

    public static void showLoading(Context context, int loadingLayout) {
        loadingDialog = new Dialog(context);
        loadingDialog.setContentView(loadingLayout);
        loadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
    }

    public static boolean isLoading() {
        if (loadingDialog != null) {
            return loadingDialog.isShowing();
        }
        return false;
    }

    public static void closeLoading() {
        if (loadingDialog != null) loadingDialog.dismiss();
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int stringToInt(String value) {
        return value == null || value.equals("") ? 0 : Integer.parseInt(value);
    }

    public static double stringToDouble(String value) {
        return value == null || value.equals("") ? 0.0 : Double.parseDouble(value);
    }

    public static float stringToFloat(String value) {
        return value == null || value.equals("") ? 0F : Float.parseFloat(value);
    }

    public static void shareText(String text, Activity activity) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        activity.startActivity(Intent.createChooser(shareIntent, "Share via"));
    }

    public static void copyText(String text, Activity activity) {
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Copied Text", text);
        clipboardManager.setPrimaryClip(clipData);
    }

}
