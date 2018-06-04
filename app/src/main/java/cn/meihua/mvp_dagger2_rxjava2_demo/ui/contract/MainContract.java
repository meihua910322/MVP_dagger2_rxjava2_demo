package cn.meihua.mvp_dagger2_rxjava2_demo.ui.contract;

import cn.meihua.mvp_dagger2_rxjava2_demo.base.BaseContract;

/**
 * Created by meihua_pc on 2018/6/4.
 */

public interface MainContract extends BaseContract {
    interface View extends BaseContract.BaseView {
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

    }
}
