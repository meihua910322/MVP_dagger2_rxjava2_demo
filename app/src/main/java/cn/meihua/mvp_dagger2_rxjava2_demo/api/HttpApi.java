package cn.meihua.mvp_dagger2_rxjava2_demo.api;


import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import cn.meihua.mvp_dagger2_rxjava2_demo.BuildConfig;
import cn.meihua.mvp_dagger2_rxjava2_demo.api.interceptor.NobodyConverterFactory;
import cn.meihua.mvp_dagger2_rxjava2_demo.api.interceptor.OkHttpInterceptor;
import cn.meihua.mvp_dagger2_rxjava2_demo.common.Constant;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.HttpsUtils;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by meih on 2017/6/9.
 */

public class HttpApi {

    private static HttpApi instance;

    private HttpApiService service;

    public HttpApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(Constant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constant.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Constant.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .hostnameVerifier(new HostnameVerifier()
                {
                    @Override
                    public boolean verify(String hostname, SSLSession session)
                    {
                        return true;
                    }
                })
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .addInterceptor(new OkHttpInterceptor()); //添加拦截器 处理response
//                .addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                //一定要在gsonConverter前面,否则gson会拦截所有的解析方式
                .addConverterFactory(NobodyConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.API_HOST)
                .build();
        service = retrofit.create(HttpApiService.class);
    }

    /**
     * 获取API对象
     *
     * @return
     */
    public static HttpApi getInstance() {
        if (instance == null) {
            instance = new HttpApi();
        }
        return instance;
    }

    public HttpApiService getHttpApiService() {
        return service;
    }
}
