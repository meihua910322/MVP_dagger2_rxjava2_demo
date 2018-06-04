package cn.meihua.mvp_dagger2_rxjava2_demo.bean;


/**
 * @author muaj
 * @date 2017/9/26
 */

public class ErrorEvent {
    /**
     * error : INVALID_VCODE
     * message : [业务层异常]验证码错误
     */

    private int code;
    private String error;
    private String message;
    private String mfa_token;

    public ErrorEvent(int code, String error, String message, String mfa_token) {
        this.code = code;
        this.message = message;
        this.error = error;
        this.mfa_token=mfa_token;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMfa_token() {
        return mfa_token;
    }

    public void setMfa_token(String mfa_token) {
        this.mfa_token = mfa_token;
    }
}
