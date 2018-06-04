package cn.meihua.mvp_dagger2_rxjava2_demo.api;

import android.support.v4.util.ArrayMap;

import java.util.Map;


/**
 * 获取Http请求 QueryMap或FieldMap
 * Created by muaj on 2017/6/12.
 */

public class ApiMap {

    /**
     * /uaa/oauth/token
     *
     * @param password
     * @return
     */
    public static Map<String, String> getOauthTokenMap(String username, String password) {
        Map<String, String> map = new ArrayMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("scope", "ui");
        map.put("grant_type", "password");
        return map;
    }

    /**
     * /uaa/oauth/token  otp验证
     *
     * @param mfaToken
     * @param otp
     * @return
     */
    public static Map<String, String> getOtpTokenMap(String mfaToken, String otp) {
        Map<String, String> map = new ArrayMap<>();
        map.put("mfa_token", mfaToken);
        map.put("otp", otp);
        map.put("grant_type", "mfa_otp");
        return map;
    }

    /**
     * /uaa/oauth/token  oob验证 step1-发送短信验证码
     *
     * @param mfaToken
     * @param oobCode
     * @return
     */
    public static Map<String, String> getOobTokenMap(String mfaToken, String oobCode) {
        Map<String, String> map = new ArrayMap<>();
        map.put("mfa_token", mfaToken);
        map.put("oob_code", oobCode);
        map.put("grant_type", "mfa_oob");
        return map;
    }

    /**
     * /uaa/oauth/token  oob验证 step2
     *
     * @param mfaToken
     * @param oobCode
     * @return
     */
    public static Map<String, String> getOobBindingTokenMap(String mfaToken, String oobCode, String bindingCode) {
        Map<String, String> map = new ArrayMap<>();
        map.put("mfa_token", mfaToken);
        map.put("oob_code", oobCode);
        map.put("binding_code", bindingCode);
        map.put("grant_type", "mfa_oob");
        return map;
    }

    /**
     * /uaa/oauth/token
     *
     * @param refresh_token
     * @return
     */
    public static Map<String, String> getRefreshTokenMap(String refresh_token) {
        Map<String, String> map = new ArrayMap<>();
        map.put("refresh_token", refresh_token);
        map.put("grant_type", "refresh_token");
        return map;
    }

}
