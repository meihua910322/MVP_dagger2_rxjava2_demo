package cn.meihua.mvp_dagger2_rxjava2_demo.base;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import cn.meihua.mvp_dagger2_rxjava2_demo.R;
import cn.meihua.mvp_dagger2_rxjava2_demo.bean.WordJsonBean;
import cn.meihua.mvp_dagger2_rxjava2_demo.callback.DialogCallback;
import cn.meihua.mvp_dagger2_rxjava2_demo.component.AppComponent;
import cn.meihua.mvp_dagger2_rxjava2_demo.databinding.ActivityBaseBinding;
import cn.meihua.mvp_dagger2_rxjava2_demo.dialog.TipDialog;
import cn.meihua.mvp_dagger2_rxjava2_demo.impl.TipDialogImpl;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.StatusBarUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.ToastUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.WordJsonUtils;


/**
 * 基类Activity
 *
 * @author dell
 * @date 2017/9/13
 */

public abstract class BaseActivity<V extends ViewDataBinding> extends AppCompatActivity implements TipDialogImpl, BaseContract.BaseView {

    protected V mBindingView;
    protected ActivityBaseBinding mBaseBinding;
    public WordJsonBean wordJsonBean;
    protected Context mContext;

    protected TipDialog mTipsDialog;
    protected Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTipsDialog = new TipDialog(this);
        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        mBindingView = DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), null, false);
        mBaseBinding.rootLayout.addView(mBindingView.getRoot(), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //moveToBack() 打包运行不起作用 所以加上下面这句
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        setContentView(mBaseBinding.getRoot());

        mContext = this;
        AppComponent appComponent = BaseApplication.getsInstance().getAppComponent();
        setupActivityComponent(appComponent);
        initWordJsonBean();
        attachView();
        initDatas();
        initStatusBar();
        if (mBaseBinding.commonToolbar != null) {
            mBaseBinding.commonToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
            mBaseBinding.commonToolbar.setTitle("");
            initToolBar();
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            setSupportActionBar(mBaseBinding.commonToolbar);
        }
        initListener();
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void toolbarSetElevation(float elevation) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBaseBinding.commonToolbar.setElevation(elevation);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTipsDialog.destoryTipsDialog();

        if (mLoadingDialog != null) {
            if (mLoadingDialog.isShowing()) {
                mLoadingDialog.dismiss();
            }
            mLoadingDialog = null;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ===================== WordJson文案 ======================
     */

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
        BaseApplication.errorJsonMap=WordJsonUtils.getErrorJsonMap(wordJsonBean);
        initWord();
    }


    /**===================== abstract 抽象方法 ======================*/

    /**
     * 获取布局
     *
     * @return
     */
    public abstract @LayoutRes
    int getLayoutId();

    /**
     * 使用Dagger2对Activity进行注入
     *
     * @param appComponent
     */
    protected abstract void setupActivityComponent(AppComponent appComponent);

    /**
     * 初始化WordJson文案
     */
    protected abstract void initWord();

    /**
     * 初始化数据
     */
    public abstract void initDatas();

    /**
     * 初始化ToolBar
     */
    public abstract void initToolBar();

    /**
     * 初始化监听事件
     */
    public abstract void initListener();

    /**
     * Presenter绑定View
     */
    public abstract void attachView();




    /**===================== StatusBar ======================*/

    /**
     * 显示状态栏
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void initStatusBar() {
        StatusBarUtils.setRootFitsSystemWindows(this, true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.setColor(this, Color.WHITE);
            StatusBarUtils.setStatusBarDark(this, true);
        } else {
            StatusBarUtils.setTranslucent(this);
        }


    }

    /**===================== LoadingDialog ======================*/

    /**
     * 正在加载显示进度条
     */
    @Override
    public void showLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new Dialog(this, R.style.progress_dialog);
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

   /*===================== Permission ======================*/

    protected void requestPermission(String[] perms, String title, String tips, @NonNull String... permissions) {
        PermissionsUtil.TipInfo tipInfo;
        String cancel = wordJsonBean != null ? WordJsonUtils.getStringNull(wordJsonBean, wordJsonBean.localization.cancel_button) : "cancel";
        String ensure = wordJsonBean != null ? WordJsonUtils.getStringNull(wordJsonBean, wordJsonBean.localization.setting) : "setting";

        tipInfo = new PermissionsUtil.TipInfo(title, tips, cancel, ensure);

        if (PermissionsUtil.hasPermission(this, permissions)) {
            afterPermission();
        } else {
            PermissionsUtil.requestPermission(this, new PermissionListener() {
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

    protected void moveToBack() {
        //此处写退向后台的处理
        //方式一：退向后台运行
        //moveTaskToBack(false);
        //方式二：回到手机主界面
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
