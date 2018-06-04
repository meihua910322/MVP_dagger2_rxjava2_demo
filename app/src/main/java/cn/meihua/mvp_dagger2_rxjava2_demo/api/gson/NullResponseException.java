package cn.meihua.mvp_dagger2_rxjava2_demo.api.gson;

/**
 * Created by muaj on 2017/9/27.
 */

public class NullResponseException extends RuntimeException {

    private int code ;  //异常对应的返回码
    private String message;  //异常对应的描述信息

    public NullResponseException() {
        super();
    }

    public NullResponseException(String message) {
        super(message);
        message = message;
    }

    public NullResponseException(int code, String message) {
        super();
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}