package cn.meihua.mvp_dagger2_rxjava2_demo.base;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import cn.meihua.mvp_dagger2_rxjava2_demo.R;
import cn.meihua.mvp_dagger2_rxjava2_demo.bean.WordJsonBean;
import cn.meihua.mvp_dagger2_rxjava2_demo.callback.DialogCallback;
import cn.meihua.mvp_dagger2_rxjava2_demo.component.AppComponent;
import cn.meihua.mvp_dagger2_rxjava2_demo.dialog.TipDialog;
import cn.meihua.mvp_dagger2_rxjava2_demo.impl.TipDialogImpl;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.ToastUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.WordJsonUtils;

/**
 * Created by meihua_pc on 2018/6/4.
 */

public abstract class BaseFragment<V extends ViewDataBinding> extends Fragment implements TipDialogImpl, BaseContract.BaseView {

    protected FragmentActivity activity;
    protected LayoutInflater inflater;
    protected V mBindingView;

    protected TipDialog mTipsDialog;
    protected Dialog mLoadingDialog;

    protected Context mContext;
    public WordJsonBean wordJsonBean;
    protected Boolean isVisible = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        mBindingView = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        activity = getSupportActivity();
        mContext = activity;
        this.inflater = inflater;
        return mBindingView.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTipsDialog = new TipDialog(getActivity());
        setupActivityComponent(BaseApplication.getsInstance().getAppComponent());
        attachView();
        initWordJsonBean();
        initDatas();
        initListener();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (FragmentActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }

    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTipsDialog.destoryTipsDialog();
        if (mLoadingDialog != null) {
            if (mLoadingDialog.isShowing()) {
                mLoadingDialog.dismiss();
            }
            mLoadingDialog = null;
        }
//        BaseApplication.getRefWatcher(mContext).watch(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;

    }

    /*===================== WordJson文案 ======================*/

    protected void initWordJsonBean() {
        if (BaseApplication.wordJsonBean == null) {
            BaseApplication.wordJsonBean = WordJsonUtils.getJsonBean();
        }
        wordJsonBean = BaseApplication.wordJsonBean;

        initWord();
    }

    /**
     * 切换语言
     */
    protected void changeLanguage() {
        BaseApplication.wordJsonBean = wordJsonBean = WordJsonUtils.changeLanguage();
        BaseApplication.errorJsonMap = WordJsonUtils.getErrorJsonMap(wordJsonBean);
        initWord();
    }

     /*===================== abstract 抽象方法 ======================*/

    /**
     * 获取布局
     *
     * @return
     */
    public abstract @LayoutRes
    int getLayoutResId();

    /**
     * 使用Dagger2对Fragment进行注入
     *
     * @param appComponent
     */
    protected abstract void setupActivityComponent(AppComponent appComponent);

    /**
     * 初始化数据
     */
    public abstract void initDatas();

    /**
     * 初始化WordJson文案
     */
    protected abstract void initWord();

    /**
     * 初始化监听事件
     */
    public abstract void initListener();

    /**
     * Presenter绑定View
     */
    public abstract void attachView();

    /**
     * 获取统计名称
     *
     * @return
     */
    public abstract String getStatisticsName();

    /*===================== TipDialog ======================*/

    @Override
    public void showTipsDialog(String message, DialogCallback callback) {
        mTipsDialog.showTipsDialog(message, callback);
    }

    @Override
    public void showTipsDialog(String message, String subtitle, DialogCallback callback) {
        mTipsDialog.showTipsDialog(message, subtitle, callback);
    }

    @Override
    public void showTipsDialog(String message, String subtitle, String sureText, DialogCallback callback) {
        mTipsDialog.showTipsDialog(message, subtitle, sureText, callback);
    }

    @Override
    public void showTipsDialog(String message, String subtitle, String sureText, String cancelText, DialogCallback callback) {
        mTipsDialog.showTipsDialog(message, subtitle, sureText, cancelText, callback);
    }

    @Override
    public void showTipsDialog(String message, String subtitle, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback) {
        mTipsDialog.showTipsDialog(message, subtitle, sureText, cancelText, hasTwoButton, callback);
    }

    @Override
    public void showTipsDialog(String message, int drawableId, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback) {
        mTipsDialog.showTipsDialog(message, drawableId, sureText, cancelText, hasTwoButton, callback);
    }

    @Override
    public void showTipsDialog(String message, int drawableId, String subtitle, String sureText, String cancelText, boolean hasTwoButton, DialogCallback callback) {
        mTipsDialog.showTipsDialog(message, drawableId, subtitle, sureText, cancelText, hasTwoButton, callback);
    }

    @Override
    public void hideTipsDialog() {
        mTipsDialog.hideTipsDialog();
    }


     /*===================== LoadingDialog ======================*/

    /**
     * 正在加载显示进度条
     */
    @Override
    public void showLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new Dialog(getActivity(), R.style.progress_dialog);
            mLoadingDialog.setContentView(R.layout.loading_dialog);
            mLoadingDialog.setCanceledOnTouchOutside(false);
        }
        mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void showToast(String toast) {
        ToastUtils.showSingleToast(toast);
    }

    /*===================== Permission ======================*/

    protected void requestPermission(String[] perms, String title, String tips, @NonNull String... permissions) {
        PermissionsUtil.TipInfo tipInfo;
        String cancel = wordJsonBean != null ? WordJsonUtils.getStringNull(wordJsonBean, wordJsonBean.localization.cancel_button) : "cancel";
        String ensure = wordJsonBean != null ? WordJsonUtils.getStringNull(wordJsonBean, wordJsonBean.localization.setting) : "setting";

        tipInfo = new PermissionsUtil.TipInfo(title, tips, cancel, ensure);

        if (PermissionsUtil.hasPermission(getActivity(), permissions)) {
            afterPermission();
        } else {
            PermissionsUtil.requestPermission(getActivity(), new PermissionListener() {
                @Override
                public void permissionGranted(@NonNull String[] permission) {
                    afterPermission();
                }

                @Override
                public void permissionDenied(@NonNull String[] permission) {
                    rejectPermission();
                }
            }, perms, true, tipInfo);
        }
    }

    protected void afterPermission() {

    }

    protected void rejectPermission() {

    }
}