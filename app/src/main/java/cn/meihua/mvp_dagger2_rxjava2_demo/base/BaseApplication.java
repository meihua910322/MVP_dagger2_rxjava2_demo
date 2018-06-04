package cn.meihua.mvp_dagger2_rxjava2_demo.base;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;

import cn.meihua.mvp_dagger2_rxjava2_demo.bean.WordJsonBean;
import cn.meihua.mvp_dagger2_rxjava2_demo.component.AppComponent;
import cn.meihua.mvp_dagger2_rxjava2_demo.component.DaggerAppComponent;
import cn.meihua.mvp_dagger2_rxjava2_demo.module.AppModule;
import cn.meihua.mvp_dagger2_rxjava2_demo.module.HttpApiModule;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.AppUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.LogUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.SharedPreferencesUtil;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.WordJsonUtils;

/**
 * Created by meihua_pc on 2018/6/4.
 */

public class BaseApplication extends Application {

    private static BaseApplication sInstance;
    public static WordJsonBean wordJsonBean;
    public static HashMap<String, String> errorJsonMap;
    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initComponent();
        AppUtils.init(this);
        LogUtils.init(this);
        initPrefs();
        initWords();
    }

    public static BaseApplication getsInstance() {
        return sInstance;
    }

    private void initComponent() {
        appComponent = DaggerAppComponent.builder()
                .httpApiModule(new HttpApiModule())
                .appModule(new AppModule(this))
                .build();
    }
    private void initWords() {
        if (wordJsonBean == null) {
            wordJsonBean = WordJsonUtils.getJsonBeanFirst(BaseApplication.this);
        }
        if (errorJsonMap == null) {
            errorJsonMap = WordJsonUtils.getErrorJsonMap(wordJsonBean);
        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    /**
     * 初始化SharedPreference
     */
    protected void initPrefs() {
        SharedPreferencesUtil.init(getApplicationContext(), getPackageName() + "_preference", Context.MODE_MULTI_PROCESS);
    }

}
