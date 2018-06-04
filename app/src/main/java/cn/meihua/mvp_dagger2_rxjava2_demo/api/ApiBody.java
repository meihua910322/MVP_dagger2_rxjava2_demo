package cn.meihua.mvp_dagger2_rxjava2_demo.api;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author muaj
 * @date 2017/12/4
 */

public class ApiBody {

    /**
     * /vcode/{usages}
     *
     * @return
     */
    public static RequestBody getVcodeBody(String content) {
        JSONObject result = new JSONObject();
        try {
            result.put("receiver", content);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RequestBody.create(MediaType.parse("application/json"), result.toString());
    }

    /**
     * /uaa/mfa/challenge
     *
     * @return
     */
    public static RequestBody getMfaChallengeBody(String mfaToken) {
        JSONObject result = new JSONObject();
        try {
            result.put("mfa_token", mfaToken);
            result.put("challenge_type", "otp|oob");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RequestBody.create(MediaType.parse("application/json"), result.toString());
    }
}
