package cn.meihua.mvp_dagger2_rxjava2_demo.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import cn.meihua.mvp_dagger2_rxjava2_demo.R;
import cn.meihua.mvp_dagger2_rxjava2_demo.base.BaseApplication;
import cn.meihua.mvp_dagger2_rxjava2_demo.callback.DialogCallback;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.PerfectClickListener;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.WordJsonUtils;


/**
 * @author muaj
 * @date 2017/11/7
 */

public class TipDialog {

    private Activity mActivity;
    private Dialog mTipsDialog;


    private TextView mTvTipsCancel;
    private TextView mTvTipsEnsure;
    private TextView mTvMessage;
    private TextView mTvSubtitle;
    private LinearLayout mLlSelect;
    private TextView mTvSelect;

    public TipDialog(@NonNull Activity activity) {
        mActivity = activity;
        initDialog(mActivity);
    }

    private void initDialog(Activity activity) {
        if (activity == null) {
            throw new RuntimeException("no activity to attach");
        }
        if (mTipsDialog == null) {
            mTipsDialog = new Dialog(activity, R.style.progress_dialog);
            View view = View.inflate(activity, R.layout.dialog_tips, null);
            mTvTipsCancel = view.findViewById(R.id.tv_cancel);
            mTvTipsEnsure = view.findViewById(R.id.tv_again);
            mTvSelect = view.findViewById(R.id.tv_select_button);
            mLlSelect = view.findViewById(R.id.ll_select_button);
            mTvMessage = view.findViewById(R.id.tv_message);
            mTvSubtitle = view.findViewById(R.id.tv_subtitle);
            mTipsDialog.setContentView(view);
            mTipsDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void showTipsDialog(String message, int drawableId, String subtitle, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback) {
        initDialog(mActivity);

        mTvMessage.setText(message);
        setmTvSubtitle(subtitle);
        if (drawableId == 0) {
            mTvMessage.setCompoundDrawables(null, null, null, null);
        } else {
            Glide.with(mActivity).load(drawableId).asBitmap().placeholder(R.drawable.img_net).into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    mTvMessage.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(mTvMessage.getResources(), resource), null, null, null);
                }
            });

        }
        if (hasTwoButton) {
            mTvSelect.setVisibility(View.GONE);
            mLlSelect.setVisibility(View.VISIBLE);
            mTvTipsEnsure.setText(sureText);
            mTvTipsCancel.setText(cancelText);
        } else {
            mTvSelect.setVisibility(View.VISIBLE);
            mLlSelect.setVisibility(View.GONE);
            mTvSelect.setText(sureText);
        }
        initNetDialogListener(callback);
        mTipsDialog.show();
    }

    public void showTipsDialog(String message, int drawableId, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback) {
        showTipsDialog(message, drawableId,null, sureText, cancelText, hasTwoButton, callback);
    }

    public void showTipsDialog(String message,String subtitle, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback) {
        showTipsDialog(message, 0, subtitle, sureText, cancelText, hasTwoButton, callback);
    }

    public void showTipsDialog(String message,String subtitle, String sureText, String cancelText, DialogCallback callback) {
        showTipsDialog(message, 0, subtitle, sureText, cancelText, true, callback);
    }

    public void showTipsDialog(String message,String subtitle, String sureText, DialogCallback callback) {
        showTipsDialog(message, 0, subtitle, sureText, "", false, callback);
    }

    public void showTipsDialog(String message,String subtitle, DialogCallback callback) {
        showTipsDialog(message, 0, subtitle,
                WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.comfirm),
                WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.cancel_button),
                true, callback);
    }

    public void showTipsDialog(String message, DialogCallback callback) {
        showTipsDialog(message, 0, null,
                WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.comfirm),
                WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.cancel_button),
                true, callback);
    }

    public void hideTipsDialog() {
        if (mTipsDialog != null && mTipsDialog.isShowing()) {
            mTipsDialog.dismiss();
        }
    }

    public void destoryTipsDialog() {
        hideTipsDialog();
        mTipsDialog = null;
        mActivity = null;
    }

    protected void initNetDialogListener(final DialogCallback callback) {
        mTvTipsCancel.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                if (mLlSelect.getVisibility() != View.VISIBLE) {
                    return;
                }
                if (mTipsDialog != null && mTipsDialog.isShowing()) {
                    mTipsDialog.dismiss();
                }
                if (callback != null) {
                    callback.dialogCancel();
                }
                //                onCancel();
            }
        });

        mTvTipsEnsure.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                if (mLlSelect.getVisibility() != View.VISIBLE) {
                    return;
                }
                if (mTipsDialog != null && mTipsDialog.isShowing()) {
                    mTipsDialog.dismiss();
                }
                if (callback != null) {
                    callback.dialogEnsure();
                }
                //                onRefresh();
            }
        });

        mTvSelect.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                if (mTvSelect.getVisibility() != View.VISIBLE) {
                    return;
                }
                if (mTipsDialog != null && mTipsDialog.isShowing()) {
                    mTipsDialog.dismiss();
                }
                if (callback != null) {
                    callback.dialogEnsure();
                }
                //                onEnsureOneButton();
            }
        });

    }

    public void setmTvSubtitle(String subtitle){
        if (TextUtils.isEmpty(subtitle)) {
            mTvSubtitle.setVisibility(View.GONE);
        } else {
            mTvSubtitle.setVisibility(View.VISIBLE);
            mTvSubtitle.setText(subtitle);
        }
    }

}
