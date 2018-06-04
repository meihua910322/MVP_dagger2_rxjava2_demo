package cn.meihua.mvp_dagger2_rxjava2_demo.api;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import cn.meihua.mvp_dagger2_rxjava2_demo.BuildConfig;

/**
 * Api常量  分组
 * Created by muaj on 2017/9/18.
 */

public final class ApiConstants {
    private ApiConstants() {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Url {
        String BASE_URL = BuildConfig.API_HOST;
        /**
         * 《数交所服务协议》 url
         */
        String SERVICE_AGREEMENT_URL = "https://www.dae.org/tos?withoutHeader=true&withoutFooter=true&lang={0}";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Path {
        String OAUTH_TOKEN = "uaa/oauth/token"; //登录-获取或刷新OAuthToken
        String MFA_CHALLENGE = "uaa/mfa/challenge"; //登录-获取用户支持的验证方式
        String CHECK_TOKEN = "uaa/oauth/check_token"; //检查OAuthToken

        String VCODE_REGISTER = "vcode/register"; //注册-获取邮箱验证码
        String FLOW_REGISTER = "flow/register"; //注册-获取flow_id
        String REGISTER_STEP1 = "register/step1";//注册-注册流程第一步，之前需先获取flow_id及验证码
        String REGISTER_STEP2 = "register/step2";//注册-注册流程第二步

        String VCODE_FORGET_PASSWORD = "vcode/forgot-password"; //忘记密码-获取邮箱验证码
        String FLOW_FORGET_PASSWORD = "flow/forgot-password"; //忘记密码-获取flow_id
        String FORGET_PASSWORD_STEP1 = "forgot-password/step1";//忘记密码-忘记密码流程第一步，之前需先获取flow_id及验证码
        String FORGET_PASSWORD_STEP2 = "forgot-password/step2";//忘记密码-忘记密码流程第二步

        String GET_PROFILE = "profile";//用户基本信息profile
        String PROFILE_AVATAR="profile/avatar";//修改用户头像
        String PROFILE_NICKNAME="profile/nickname";//修改用户昵称
        String CONTRACT="trade/contracts";//交易对
        String TRADE_ORDERS="trade/orders";//下单

        String VCODE_MODIFY_PASSWORD = "vcode/modify-password"; //修改登录密码-获取邮箱验证码
        String MODIFY_LOGIN_PASSWORD = "profile/password"; //修改登录密码-修改用户密码

        String CHECK_EMAIL_EXIST = "profile/email/existence";//更换邮箱-查询某邮箱是否已经被注册
        String VCODE_RESET_EMAIL = "vcode/reset-email"; //更换邮箱-获取邮箱验证码
        String RESET_EMAIL = "profile/email"; //更换邮箱-修改用户邮箱

        String GET_MESSAGES = "users/messages"; //消息中心消息列表
        String MESSAGE_DETAIL = "users/messages/"; //消息详情
        String READ_OR_DELETE_MESSAGES = "users/messages"; //读取/删除消息
        String MESSAGES_STATISTICS = "users/messages/statistics"; // 查询收信统计

        String BANNERS = "cms/banners?classification=Banner&type=Android"; // 查询banner列表
        String SPLASH = "cms/banners?classification=Splash&type=Android"; // 查询splash广告列表

        String CHECK_UPDATE = "versions/check-update"; //检查版本更新

        String AUTH_PREFERENCES = "preferences/"; //获取认证状态


    }


    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
        int TOKEN_INVALID = 400;
        int FORBIDDEN = 403;
        int FORCE_UPDATE = 406;

        int NET_CODE_AVAILABLE = 1000;
        int NET_CODE_CONNECT = 1001;
        int NET_CODE_SOCKET_TIMEOUT = 1002;
        int NET_CODE_UNKNOWN_HOST = 1003;
        int NULL_POINTER = 2000;
        int JSON_PARSE = 3000;
        int IO_EXCEPTION = 4000;
        int NULL_RESPONSE = 5000;
        int UNKNOWN_EXCEPTION = 6000;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorMsg {
        String NET_AVAILABLE_EXCEPTION = "网络未连接或不可用,请检查您的网络状态,稍后重试";
        String NET_CONNECT_EXCEPTION = "网络连接异常,请检查您的网络状态";
        String SOCKET_TIMEOUT_EXCEPTION = "网络连接超时,请检查您的网络状态,稍后重试";
        String UNKNOWN_HOST_EXCEPTION = "网络异常,请检查您的网络状态";
        String NULL_POINTER_EXCEPTION = "空指针错误";
        String JSON_PARSE_EXCEPTION = "数据解析异常";
        String IO_EXCEPTION = "IO异常";
        String NULL_RESPONSE_EXCEPTION = "Response无响应体或为null";
        String UNKNOWN_EXCEPTION = "未知异常";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TokenCallBack{
        String OauthToken = "OauthToken";
        String MfaToken = "MfaToken";
        String CheckToken = "CheckToken";
        String RefreshToken = "RefreshToken";
        String GetProfile = "GetProfile";
    }
}
