package cn.meihua.mvp_dagger2_rxjava2_demo.api.gson;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.nio.charset.Charset;

import cn.meihua.mvp_dagger2_rxjava2_demo.api.ApiConstants;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Converter;

/**
 * Created by muaj on 2017/9/27.
 */

public class CustomGsonResponseConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            BufferedSource source = value.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            String body = buffer.clone().readString(Charset.forName("UTF-8"));
           // LogUtils.e("Response body ==>"+body);

            if (TextUtils.isEmpty(body) || "null".equals(body.toLowerCase())) {
                throw new NullResponseException(ApiConstants.ErrorCode.NULL_RESPONSE, ApiConstants.ErrorMsg.NULL_RESPONSE_EXCEPTION);  //抛出自定义异常
            }
            return adapter.fromJson(body);

        } finally {
            value.close();
        }

    }
}
