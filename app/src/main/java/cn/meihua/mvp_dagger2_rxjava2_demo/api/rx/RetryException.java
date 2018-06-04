package cn.meihua.mvp_dagger2_rxjava2_demo.api.rx;


import com.google.gson.Gson;

import java.nio.charset.Charset;

import cn.meihua.mvp_dagger2_rxjava2_demo.bean.ErrorEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.HttpException;

/**
 * 刷新token后重发http请求
 *
 * @author muaj
 * @date 2018/2/2
 */

public class RetryException implements Function<Observable<? extends Throwable>, Observable<?>> {


    public RetryException() {

    }

    @Override
    public Observable<?> apply(Observable<? extends Throwable> observable) throws Exception {
        return observable.zipWith(Observable.range(1, 2), new BiFunction<Throwable, Integer, Throwable>() {
            @Override
            public Throwable apply(Throwable throwable, Integer integer) throws Exception {
                return throwable;
            }
        }).flatMap(new Function<Throwable, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Throwable throwable) throws Exception {
                if (throwable instanceof HttpException) {

                    ResponseBody responseBody = ((HttpException) throwable).response().errorBody();
                    BufferedSource source = responseBody.source();
                    source.request(Long.MAX_VALUE); // request the entire body.
                    Buffer buffer = source.buffer();
                    String responseBodyString = buffer.clone().readString(Charset.forName("UTF-8"));

                    ErrorEvent errorEvent = new Gson().fromJson(responseBodyString, ErrorEvent.class);
                    if (errorEvent != null && errorEvent.getError() != null && "invalid_token".equals(errorEvent.getError())) {
                        //todo 此处是需要重新发送请求
//                        if (null == BaseApplication.refreshToken || TextUtils.isEmpty(BaseApplication.refreshToken)) {
//                            return Observable.error(throwable);
//                        } else {
//                            return ApiRepository.refreshToken(ApiMap.getRefreshTokenMap(TokenUtils.getRefreshToken()))
//                                    .doOnNext(new Consumer<TokenBean>() {
//                                        @Override
//                                        public void accept(TokenBean tokenBean) throws Exception {
//                                            //LogUtils.e("muaj", tokenBean.getAccess_token());
//                                            SharedPreferencesUtil.getInstance().putToken(tokenBean);
//                                            EventBus.getDefault().post(new LoginSuccessEvent("success"));
//                                        }
//                                    });
//                        }
                    }

                }
                return Observable.error(throwable);
            }
        });

    }
}
