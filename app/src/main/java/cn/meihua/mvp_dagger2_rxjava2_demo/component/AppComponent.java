package cn.meihua.mvp_dagger2_rxjava2_demo.component;

import android.content.Context;

import cn.meihua.mvp_dagger2_rxjava2_demo.api.HttpApi;
import cn.meihua.mvp_dagger2_rxjava2_demo.module.AppModule;
import cn.meihua.mvp_dagger2_rxjava2_demo.module.HttpApiModule;
import dagger.Component;


/**
 * Created by dell on 2017/9/13.
 */

@Component(modules = {AppModule.class, HttpApiModule.class})
public interface AppComponent {
    Context getContext();
    HttpApi getHttpApi();
}
