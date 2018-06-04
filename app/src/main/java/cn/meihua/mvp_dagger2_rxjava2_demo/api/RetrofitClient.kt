package org.dae.exchange.common.api

import android.text.TextUtils
import cn.meihua.mvp_dagger2_rxjava2_demo.BuildConfig
import cn.meihua.mvp_dagger2_rxjava2_demo.api.ApiConstants
import cn.meihua.mvp_dagger2_rxjava2_demo.api.gson.CustomGsonConverterFactory
import cn.meihua.mvp_dagger2_rxjava2_demo.common.Constant
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.DeviceUtils
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.HttpsUtils
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.LogUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


/**
 *
 * @author muaj
 * @date 2017/12/6
 */
object RetrofitClient {

    private var mRetrofit: Retrofit? = null

    private val HTTP_TAG:String="okhttp"

    fun <T> createService(serviceClass: Class<T>): T {

        if (mRetrofit == null) {
            val sslParams = HttpsUtils.getSslSocketFactory(null, null, null) //https
            val httpClientBuilder = OkHttpClient().newBuilder()
                    .connectTimeout(Constant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(Constant.READ_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(Constant.WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .hostnameVerifier { _, _ -> true }
                    .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                    .addInterceptor{ chain ->
                        val request = chain.request()
                                .newBuilder()
                                .addHeader("User-Agent", "Android Mobile/" + DeviceUtils.getDeviceName() + "/" + DeviceUtils.getDeviceSDK())
                                .addHeader("X-Application-Version", BuildConfig.VERSION_CODE.toString())
                                .addHeader("Origin", ApiConstants.Url.BASE_URL.replace("api","www").substring(0,ApiConstants.Url.BASE_URL.length-1))
                                .build()

                        var response = chain.proceed(request)
                        if (response.code() == 204) {
                            response = response.newBuilder().code(200).build()
                        }
                        response
                    }

            if (Constant.LOG_DEBUG) {
                val logInterceptor = HttpLoggingInterceptor(
                        HttpLoggingInterceptor.Logger { message ->
                            if (TextUtils.isEmpty(message)) return@Logger
                            LogUtils.i(HTTP_TAG, message)
                        })
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                httpClientBuilder.addInterceptor(logInterceptor)
            }

            mRetrofit = Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .baseUrl(ApiConstants.Url.BASE_URL)
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
        return mRetrofit!!.create(serviceClass)
    }
}