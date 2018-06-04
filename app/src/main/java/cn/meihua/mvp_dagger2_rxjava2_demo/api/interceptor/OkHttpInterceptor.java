/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.meihua.mvp_dagger2_rxjava2_demo.api.interceptor;


import java.io.IOException;
import java.nio.charset.Charset;

import cn.meihua.mvp_dagger2_rxjava2_demo.utils.AppUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.DeviceUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.LogUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Retrofit2 Header拦截器。用于保存和设置Cookies
 * <p>
 * 可以为request添加全局的header
 *
 * @author yuyh.
 * @date 16/8/6.
 */
public final class OkHttpInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        //打印request url
        Request request = chain.request()
                .newBuilder()
                .addHeader("User-Agent", "Android Mobile/" + DeviceUtils.getDeviceName() + "/" + DeviceUtils.getDeviceSDK() + "/" + DeviceUtils.getDisplayMetrics(AppUtils.getAppContext()))
                .addHeader("X-Application-Version", AppUtils.getVersionName())
                .build();
//        LogUtils.e("request url = " + request.url().toString());
        LogUtils.e("request header = " + request.headers().toString());

        //打印response header和body
        Response response = chain.proceed(request);

        //获取Response的body的字符串 并打印
        ResponseBody body = response.body();
        //long contentLength = body.contentLength();
        BufferedSource source = body.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        LogUtils.e("url = " + request.url().toString());
        LogUtils.e("response code = " + response.toString());
        LogUtils.e("response body = " + buffer.clone().readString(UTF8));

        return response;
    }
}
