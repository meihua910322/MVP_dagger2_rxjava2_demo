package cn.meihua.mvp_dagger2_rxjava2_demo.ui.activity;

import javax.inject.Inject;

import cn.meihua.mvp_dagger2_rxjava2_demo.R;
import cn.meihua.mvp_dagger2_rxjava2_demo.base.BaseActivity;
import cn.meihua.mvp_dagger2_rxjava2_demo.component.AppComponent;
import cn.meihua.mvp_dagger2_rxjava2_demo.component.DaggerMainComponent;
import cn.meihua.mvp_dagger2_rxjava2_demo.databinding.ActivityMainBinding;
import cn.meihua.mvp_dagger2_rxjava2_demo.ui.contract.MainContract;
import cn.meihua.mvp_dagger2_rxjava2_demo.ui.presenter.MainPresenter;

/**
 * Created by meihua_pc on 2018/6/4.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainContract.View {

    @Inject
    MainPresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected void initWord() {

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();

    }
}
