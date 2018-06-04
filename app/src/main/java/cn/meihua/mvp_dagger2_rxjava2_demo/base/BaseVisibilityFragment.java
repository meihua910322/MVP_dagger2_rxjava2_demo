package cn.meihua.mvp_dagger2_rxjava2_demo.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import cn.meihua.mvp_dagger2_rxjava2_demo.callback.OnFragmentVisibilityChangedListener;


/**
 * Created by meihua on 2018/1/2.
 */

public abstract class BaseVisibilityFragment<V extends ViewDataBinding> extends BaseFragment<V> implements View.OnAttachStateChangeListener, OnFragmentVisibilityChangedListener {
    /**
     * ParentActivity是否可见
     */
    private boolean mParentActivityVisible = false;
    /**
     * 是否可见（Activity处于前台、Tab被选中、Fragment被添加、Fragment没有隐藏、Fragment.View已经Attach）
     */
    private boolean mVisible = false;

    private BaseVisibilityFragment mParentFragment;
    private OnFragmentVisibilityChangedListener mListener;

    public void setOnVisibilityChangedListener(OnFragmentVisibilityChangedListener listener) {
        mListener = listener;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        final Fragment parentFragment = getParentFragment();
        if (parentFragment != null && parentFragment instanceof BaseVisibilityFragment) {
            mParentFragment = ((BaseVisibilityFragment) parentFragment);
            mParentFragment.setOnVisibilityChangedListener(this);
        }
        checkVisibility(true);
    }

    @Override
    public void onDetach() {
        if (mParentFragment != null) {
            mParentFragment.setOnVisibilityChangedListener(null);
        }
        super.onDetach();
        checkVisibility(false);
        mParentFragment = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        onActivityVisibilityChanged(true);
    }

    @Override
    public void onStop() {
        super.onStop();
        onActivityVisibilityChanged(false);
    }

    /**
     * ParentActivity可见性改变
     */
    protected void onActivityVisibilityChanged(boolean visible) {
        mParentActivityVisible = visible;
        checkVisibility(visible);
    }

    /**
     * ParentFragment可见性改变
     */
    @Override
    public void onFragmentVisibilityChanged(boolean visible) {
        checkVisibility(visible);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.addOnAttachStateChangeListener(this);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        checkVisibility(hidden);
    }

    /**
     * Tab切换时会回调此方法。对于没有Tab的页面，{@link Fragment#getUserVisibleHint()}默认为true。
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        checkVisibility(isVisibleToUser);
    }

    @Override
    public void onViewAttachedToWindow(View v) {
        checkVisibility(true);
    }

    @Override
    public void onViewDetachedFromWindow(View v) {
        v.removeOnAttachStateChangeListener(this);
        checkVisibility(false);
    }

    /**
     * 检查可见性是否变化
     *
     * @param expected 可见性期望的值。只有当前值和expected不同，才需要做判断
     */
    private void checkVisibility(boolean expected) {
        if (expected == mVisible) return;
        final boolean parentVisible = mParentFragment == null ? mParentActivityVisible : mParentFragment.isFragmentVisible();
        final boolean superVisible = super.isVisible();
        final boolean hintVisible = getUserVisibleHint();
        final boolean visible = parentVisible && superVisible && hintVisible;

        if (visible != mVisible) {
            mVisible = visible;
            onVisibilityChanged(mVisible);
        }
    }

    /**
     * 可见性改变
     */
    protected void onVisibilityChanged(boolean visible) {
        if (mListener != null) {
            mListener.onFragmentVisibilityChanged(visible);
        }
    }

    /**
     * 是否可见（Activity处于前台、Tab被选中、Fragment被添加、Fragment没有隐藏、Fragment.View已经Attach）
     */
    public boolean isFragmentVisible() {
        return mVisible;
    }


}
