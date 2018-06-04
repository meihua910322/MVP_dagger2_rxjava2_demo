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
package cn.meihua.mvp_dagger2_rxjava2_demo.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.meihua.mvp_dagger2_rxjava2_demo.common.Constant;

public class AppUtils {

    private static Context mContext;
    private static Thread mUiThread;
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void init(Context context) {
        mContext = context;
        mUiThread = Thread.currentThread();
    }

    public static Context getAppContext() {
        return mContext;
    }

    public static AssetManager getAssets() {
        return mContext.getAssets();
    }

    public static Resources getResource() {
        return mContext.getResources();
    }

    public static boolean isUIThread() {
        return Thread.currentThread() == mUiThread;
    }

    public static void runOnUI(Runnable r) {
        sHandler.post(r);
    }

    public static void runOnUIDelayed(Runnable r, long delayMills) {
        sHandler.postDelayed(r, delayMills);
    }

    public static void removeRunnable(Runnable r) {
        if (r == null) {
            sHandler.removeCallbacksAndMessages(null);
        } else {
            sHandler.removeCallbacks(r);
        }
    }

    /**
     * 获取当前应用的VersionName
     */
    public static String getVersionName() {
        // 获取packagemanager的实例
        PackageManager packageManager = getAppContext().getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(getAppContext().getPackageName(), 0);
            return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "1.0";
        }
    }

    /**
     * 获取当前应用的VersionCode
     */
    public static int getVersionCode() {
        // 获取packagemanager的实例
        PackageManager packageManager = getAppContext().getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(getAppContext().getPackageName(), 0);
            return packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * 实现文本复制功能
     *
     * @param content 复制的文本
     */
    public static void copy(String content) {
        // 得到剪贴板管理器
        ClipboardManager clipboardManager = (ClipboardManager) getAppContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("text", content);
        clipboardManager.setPrimaryClip(clipData);
        //        ToastUtils.showSingleToast(WordJsonUtils.getStringNull(BaseApplication.wordJsonBean, BaseApplication.wordJsonBean.localization.deposit_address_copy_succeeded));
    }

    /**
     * 使用浏览器打开链接
     */
    public static void openLink(Context context, String content) {
        Uri issuesUrl = Uri.parse(content);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setDataAndType(issuesUrl, "text/html");
        context.startActivity(intent);
    }

    /**
     * 获得状态栏/通知栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * 读取baseurl
     *
     * @param url
     * @return
     */
    public static String getBasUrl(String url) {
        String head = "";
        int index = url.indexOf("://");
        if (index != -1) {
            head = url.substring(0, index + 3);
            url = url.substring(index + 3);
        }
        index = url.indexOf("/");
        if (index != -1) {
            url = url.substring(0, index + 1);
        }
        return head + url;
    }

    /**
     * 判断当前系统语言是否是中文
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean isChinese() {
        return "CN".equals(getAppContext().getResources().getConfiguration().getLocales().get(0).getCountry());

    }

    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     *
     * @param timeStamp 时间戳 如："1473048265";
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String timeStamp2Date(Long timeStamp, String format) {
        String formats = TextUtils.isEmpty(format) ? "yyyy-MM-dd HH:mm:ss" : format;
        return new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timeStamp));
    }

    /**
     * 获取系统时间的时间戳
     *
     * @return
     */
    public static Long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public static long getTimeStampZero() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }


    /**
     * 获取手机系统语言类型
     *
     * @return
     */
    public static String getSystemLanguage() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        String language = locale.getLanguage()/* + "-" + locale.getCountry()*/;

        switch (language) {
            case Constant.LANGUAGE_EN:
                return Constant.LANGUAGE_EN;
            case Constant.LANGUAGE_ZH:
                return Constant.LANGUAGE_ZH;
            default:
                return Constant.LANGUAGE_EN;
        }
    }


    /**
     * 订阅socket 参数
     */
    public static String subscribeSocketParm(String msgType, String clientRequestId, @NonNull String channel) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"msgType\":");
        if (TextUtils.isEmpty(msgType)) {
            stringBuffer.append("\"SubscribeChannelRequest\"");
        } else {
            stringBuffer.append("\"" + msgType + "\"");
        }
        stringBuffer.append(",");
        if (!TextUtils.isEmpty(clientRequestId)) {
            stringBuffer.append("\"clientRequestId\":");
            stringBuffer.append("\"" + clientRequestId + "\"");
            stringBuffer.append(",");
        }
        stringBuffer.append("\"channel\":");
        stringBuffer.append("\"" + channel + "\"");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }


    public static boolean isEmpty(String text) {
        return TextUtils.isEmpty(text) || "null".equals(text);
    }

    public static boolean isMIUI() {
        try {
            final BuildProperties prop = BuildProperties.newInstance();
            return prop.getProperty(KEY_MIUI_VERSION_CODE, null) != null || prop.getProperty(KEY_MIUI_VERSION_NAME, null) != null
                    || prop.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null;
        } catch (final IOException e) {
            return false;
        }

    }

    public static boolean isFlyme() {
        try {
            final Method method = Build.class.getMethod("hasSmartBar");
            return method != null;
        } catch (final Exception e) {
            return false;
        }
    }


}
