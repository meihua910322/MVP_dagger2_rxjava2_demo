package cn.meihua.mvp_dagger2_rxjava2_demo.module;


import cn.meihua.mvp_dagger2_rxjava2_demo.api.HttpApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by dell on 2017/9/13.
 */
@Module
public class HttpApiModule {
    //// TODO: 2017/9/13
    @Provides
    protected HttpApi provideApi() {
        return HttpApi.getInstance();
    }
}
