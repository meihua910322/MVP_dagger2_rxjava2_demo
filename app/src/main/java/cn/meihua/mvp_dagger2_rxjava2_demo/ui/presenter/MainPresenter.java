package cn.meihua.mvp_dagger2_rxjava2_demo.ui.presenter;

import android.content.Context;

import javax.inject.Inject;

import cn.meihua.mvp_dagger2_rxjava2_demo.base.RxPresenter;
import cn.meihua.mvp_dagger2_rxjava2_demo.ui.contract.MainContract;

/**
 * Created by meihua_pc on 2018/6/4.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {

    private Context mContext;

    @Inject
    public MainPresenter(Context mContext) {
        this.mContext = mContext;
    }
}
