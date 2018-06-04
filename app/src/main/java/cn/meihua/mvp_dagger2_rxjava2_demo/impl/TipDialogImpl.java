package cn.meihua.mvp_dagger2_rxjava2_demo.impl;


import cn.meihua.mvp_dagger2_rxjava2_demo.callback.DialogCallback;

/**
 * @author muaj
 * @date 2017/11/7
 */

public interface TipDialogImpl {

    void showTipsDialog(String message, DialogCallback callback);

    void showTipsDialog(String message, String subtitle, DialogCallback callback);

    void showTipsDialog(String message, String subtitle, String sureText, DialogCallback callback);

    void showTipsDialog(String message, String subtitle, String sureText, String cancelText, DialogCallback callback);

    void showTipsDialog(String message, String subtitle, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback);

    void showTipsDialog(String message, int drawableId, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback);

    void showTipsDialog(String message, int drawableId, String subtitle, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback);

    void hideTipsDialog();

}
