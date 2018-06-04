package cn.meihua.mvp_dagger2_rxjava2_demo.api.rx;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import cn.meihua.mvp_dagger2_rxjava2_demo.api.ApiConstants;
import cn.meihua.mvp_dagger2_rxjava2_demo.api.gson.NullResponseException;
import cn.meihua.mvp_dagger2_rxjava2_demo.base.BaseApplication;
import cn.meihua.mvp_dagger2_rxjava2_demo.bean.ErrorEvent;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.LogUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.NetworkUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.WordJsonUtils;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * 封装Rxjava的Observer 在里面做一些预处理
 *
 * @author muaj
 * @date 2017/6/22
 */

public abstract class RxObserver<T> extends DisposableObserver<T> {

    private Context mContext;

    public RxObserver(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onStart() {
        onRxStart();
        super.onStart();
    }

    @Override
    public void onNext(T t) {
        onRxNext(t);
    }

    @Override
    public void onError(Throwable e) {
        LogUtils.e("onError==>" + e.getMessage());
        if (e instanceof NullResponseException) {
            onNext(null);
        } else {
            if (e instanceof CompositeException) {
                for (Throwable ex : ((CompositeException) e).getExceptions()) {
                    handleException(ex);
                }
            } else {
                handleException(e);
            }
        }
    }

    private void handleException(Throwable e) {
        if (e instanceof HttpException) {
            HttpException ex = (HttpException) e;
            try {
                //406强更
                if (ex.code() == ApiConstants.ErrorCode.FORCE_UPDATE) {
                    error(ex.code(), "", "");
                    if (!ex.response().raw().request().url().toString().contains(ApiConstants.Path.CONTRACT)
                            || mContext.getClass().getSimpleName().contains("LoadingActivity")) {
                        getLastestVersionInfo();
                    }

                } else {
                    ErrorEvent errorEvent = new Gson().fromJson(ex.response().errorBody().charStream(), ErrorEvent.class);
                    error(ex.code(), errorEvent.getError(), errorEvent.getMfa_token());
                }
            } catch (IllegalStateException ep) {
                error(ApiConstants.ErrorCode.JSON_PARSE, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);

            } catch (JsonSyntaxException ep) {
                error(ApiConstants.ErrorCode.JSON_PARSE, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
            }

        } else if (e instanceof NetworkErrorException || e instanceof UnknownHostException) {
            if (!NetworkUtils.isAvailable() || !NetworkUtils.isConnected()) {
                error(ApiConstants.ErrorCode.NET_CODE_AVAILABLE, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
            } else {
                error(ApiConstants.ErrorCode.NET_CODE_UNKNOWN_HOST, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
            }
        } else if (e instanceof SocketTimeoutException) {
            error(ApiConstants.ErrorCode.NET_CODE_SOCKET_TIMEOUT, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
        } else if (e instanceof ConnectException) {
            error(ApiConstants.ErrorCode.NET_CODE_CONNECT, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
        } else if (e instanceof NullPointerException) {
            error(ApiConstants.ErrorCode.NULL_POINTER, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException
                || e instanceof ClassCastException
                || e instanceof IllegalStateException
                || e instanceof MalformedJsonException) {
            error(ApiConstants.ErrorCode.JSON_PARSE, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
        } else if (e instanceof IOException) {
            error(ApiConstants.ErrorCode.IO_EXCEPTION, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
        } else {
            error(ApiConstants.ErrorCode.UNKNOWN_EXCEPTION, WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.internet_error), null);
        }
    }

    private void error(int code, String error, String mfa_token) {
        if (BaseApplication.errorJsonMap == null) {
            BaseApplication.errorJsonMap = WordJsonUtils.getErrorJsonMap(BaseApplication.wordJsonBean);
        }
        String message = error;
        if (BaseApplication.errorJsonMap != null) {
            String errorValue = BaseApplication.errorJsonMap.get(error);
            if (!TextUtils.isEmpty(errorValue)) {
                message = errorValue;
            }
        }
        ErrorEvent errorEvent = new ErrorEvent(code, error, message, mfa_token);
        onRxError(errorEvent);
    }

    @Override
    public void onComplete() {
        //LogUtils.e("onComplete");
    }

    protected abstract void onRxStart();

    protected abstract void onRxNext(T t);

    /**
     * 错误处理
     *
     * @param errorEvent
     */
    protected abstract void onRxError(ErrorEvent errorEvent);


    /**
     * 获取最新版本信息
     */
    private void getLastestVersionInfo() {
        //todo 下载更新
//        DownLoadApkUtils.checkUpdate(mContext, new DownLoadApkUtils.RxCallBack() {
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onNext(UpdateBean updateBean) {
//                DownLoadApkUtils.showDownLoadTips(mContext, updateBean);
//            }
//
//            @Override
//            public void onError(ErrorEvent errorEvent) {
//
//            }
//        });
    }

}
