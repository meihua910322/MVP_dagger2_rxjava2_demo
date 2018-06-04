package cn.meihua.mvp_dagger2_rxjava2_demo.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dell on 2017/9/13.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context){
        this.context=context;

    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
