package cn.meihua.mvp_dagger2_rxjava2_demo.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;

import cn.meihua.mvp_dagger2_rxjava2_demo.bean.WordJsonBean;
import cn.meihua.mvp_dagger2_rxjava2_demo.common.Constant;


/**
 * 文案json工具类
 * Created by meih on 2017/7/12.
 */

public class WordJsonUtils {

    private static String word_json_name;
    private static String word_file_name;

    private static void getJsonName() {
        String language_categories = SharedPreferencesUtil.getInstance().getString(Constant.LANGUAGE_CATEGORIES);
        if (null == language_categories) {
            language_categories = AppUtils.getSystemLanguage();
        }
        if (language_categories.equals(Constant.LANGUAGE_ZH)) {
            word_json_name = Constant.WORD_JSON_NAME_CN;
            word_file_name = Constant.WORD_JSON_FILENAME_CN;
        } else {
            word_json_name = Constant.WORD_JSON_NAME_EN;
            word_file_name = Constant.WORD_JSON_FILENAME_EN;
        }
    }

    public static String getLanguageCategory() {
        String language_categories = SharedPreferencesUtil.getInstance().getString(Constant.LANGUAGE_CATEGORIES);
        if (null == language_categories) {
            language_categories = AppUtils.getSystemLanguage();
        }
        return language_categories;
    }


    /**
     * json本地文件存储地址
     *
     * @return
     */
    public static String getJsonFilePath(String fileName) {
        String storagePath;
        if (FileUtils.isSdCardAvailable()) {
            storagePath = AppUtils.getAppContext().getExternalCacheDir() + "/" + fileName + "/";
        } else {
            storagePath = AppUtils.getAppContext().getFilesDir() + "/" + fileName + "/";
        }
        File f = new File(storagePath);
        if (!f.exists()) {
            f.mkdir();
        }
        return storagePath + fileName + ".json";
    }


    /**
     * 从assets中读取文件转化为字符串
     *
     * @param context
     * @return
     */
    public static String getStringFromAssets(Context context) {
        if (word_file_name == null || word_json_name == null) {
            getJsonName();
        }
        StringBuilder sb = new StringBuilder();
        AssetManager am = context.getAssets();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(am.open(word_json_name)));
            String next = "";
            while (null != (next = br.readLine())) {
                sb.append(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }

    /**
     * 从 本地文件读取内容
     *
     * @return
     */
    public static String getStringFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            File file = new File(getJsonFilePath(fileName));
            if (!file.exists()) {
                return "";

            }
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 比较assets中的json和本地文件中的json的版本号
     *
     * @param context
     */
    public static String compareJsonVersion(Context context) {
        if (word_file_name == null || word_json_name == null) {
            getJsonName();
        }
        String strAssets = getStringFromAssets(context);
        String strFile = getStringFromFile(word_file_name);
        if (TextUtils.isEmpty(strFile)) {
            writeToFile(strAssets, word_file_name);
            return strAssets;
        } else {
            Gson gson1 = new Gson();
            WordJsonBean wordJsonBean1 = gson1.fromJson(strAssets, WordJsonBean.class);
            String versionAssets = wordJsonBean1.version;
            Gson gson2 = new Gson();
            WordJsonBean wordJsonBean2 = gson2.fromJson(strFile, WordJsonBean.class);
            String versionFile = wordJsonBean2.version;
            int a = compareVersion(versionAssets, versionFile);
            if (a == 1) {
                writeToFile(strAssets, word_file_name);
                return strAssets;
            } else {
                return strFile;
            }
        }
    }

    public static void writeToFile(String sorce, String fileName) {

        try {
            String path = getJsonFilePath(fileName);
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println(sorce);// 往文件里写入字符串
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * 版本号比较
     *
     * @param version1
     * @param version2
     * @return 0代表相等，1代表version1大于version2，-1代表version1小于version2
     */
    public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int index = 0;
        // 获取最小长度值
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;
        // 循环判断每位的大小
        while (index < minLen
                && (diff = Integer.parseInt(version1Array[index])
                - Integer.parseInt(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            // 如果位数不一致，比较多余位数
            for (int i = index; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    /**
     * 第一次获取时  需要比较asset和本地文件版本号 将字符串转换为 对象
     *
     * @return
     */
    @Nullable
    public static WordJsonBean getJsonBeanFirst(Context context) {

        try {
            String json = compareJsonVersion(context.getApplicationContext());
            Gson gson = new Gson();
            return gson.fromJson(json, WordJsonBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将字符串转换为 对象
     *
     * @return
     */
    @Nullable
    public static WordJsonBean getJsonBean() {
        if (word_file_name == null || word_json_name == null) {
            getJsonName();
        }

        try {
            String json = getStringFromFile(word_file_name);
            if (TextUtils.isEmpty(json)) {
                json = getStringFromAssets(AppUtils.getAppContext());
                writeToFile(json, word_file_name);
            }
            Gson gson = new Gson();
            return gson.fromJson(json, WordJsonBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static WordJsonBean changeLanguage() {
        getJsonName();
        return getJsonBean();
    }

    /**
     * 返回字符串 防止空指针
     *
     * @param str
     * @return
     */
    public static String getStringNull(WordJsonBean bean, String str) {
        if (bean == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }

    public static HashMap<String, String> getErrorJsonMap(WordJsonBean wordJsonBean) {

        if (wordJsonBean == null) {
            return null;
        }
        WordJsonBean.ErrorMassageBean errorMassageBean = wordJsonBean.error_massage;
        if (errorMassageBean == null) {
            return null;
        }

        String errorJson = new Gson().toJson(errorMassageBean);
        try {
            HashMap<String, String> errorMap = new HashMap<>();
            JSONObject jsonObject = new JSONObject(errorJson);
            Iterator iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = iterator.next().toString();
                errorMap.put(key, jsonObject.get(key).toString());
            }
            return errorMap;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
