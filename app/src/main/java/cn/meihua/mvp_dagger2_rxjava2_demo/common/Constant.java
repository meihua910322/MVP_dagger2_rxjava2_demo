package cn.meihua.mvp_dagger2_rxjava2_demo.common;


import java.math.BigDecimal;

import cn.meihua.mvp_dagger2_rxjava2_demo.BuildConfig;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.AppUtils;
import cn.meihua.mvp_dagger2_rxjava2_demo.utils.FileUtils;

/**
 * Created by dell on 2017/9/13.
 */

public class Constant {
    /**
     * 超时重连
     */
    public static final long CONNECT_TIMEOUT = 20;

    /**
     * 读超时
     */
    public static final long READ_TIMEOUT = 20;

    /**
     * 写超时
     */
    public static final long WRITE_TIMEOUT = 20;


    /**
     * 更新下载地址
     */
    public static final String DOWNLOAD_APK_URL = "";
    /**
     * 文件存储路径
     */
    public static String PATH_DATA = FileUtils.createRootPath(AppUtils.getAppContext()) + "/cache";

    public static final String COIN_ETC = "ETC";

    public static final String SUFFIX_TXT = ".txt";
    public static final String SUFFIX_PDF = ".pdf";
    public static final String SUFFIX_EPUB = ".epub";
    public static final String SUFFIX_ZIP = ".zip";
    public static final String SUFFIX_CHM = ".chm";

    /**
     * 登录页图片保存地址
     */
    public static final String LOADING_PIC_PATH = "loading_pic_path.png";

    /**
     * 统一文案的json名称
     */
    public static final String WORD_JSON_NAME_CN = "DAE_localization_CN.json";
    public static final String WORD_JSON_NAME_EN = "DAE_localization_EN.json";

    public static final String WORD_JSON_FILENAME_CN = "word_json_cn";
    public static final String WORD_JSON_FILENAME_EN = "word_json_en";


    /**
     * 中文
     */
    public static final String LANGUAGE_ZH = "zh";
    /**
     * 英文
     */
    public static final String LANGUAGE_EN = "en";

    /**
     * 用户设置的语言种类
     */
    public static final String LANGUAGE_CATEGORIES = LANGUAGE_EN;

    //public static final String ACCESS_TOKRN = "access_token";
    public static final String REFRESH_TOKRN = "refresh_token";

    public static final String EXPIRE_IN = "expires_in";
    public static final String TOKEN_TYPE = "token_type";
    public static final String SCOPE = "scope";
    public static final String JTI = "jti";

    public static final String PROFILE = "profile";
    public static final String AUTH = "auth_preferences";

    /**
     * 交易对
     */
    public static final String CONTRACT_COIN = "contract_coin";

    /**
     * 基准币
     */
    public static final String QUOTE_COIN = "quote_coin";

    /**
     * 后台回到前台--指纹验证
     */
    public static final String VERIFY_FINFERPRINT = "verify_fingerprint";
    /**
     * 后台回到前台--手势密码
     */
    public static final String VERIFY_GESTURE = "verify_gesture";


    /**
     * 手势密码模式：设置/修改/验证
     */
    public interface GESTURE_MODE {
        int SET = 0;
        int ALTER = 1;
        int VERIFY = 2;
    }

    public static final String COIN_TYPE_BTC = "BTC";
    public static final String COIN_TYPE_ETC = "ETC";
    public static final String COIN_TYPE_ETH = "ETH";
    public static final String COIN_TYPE_LTC = "LTC";
    public static final String COIN_TYPE_XUC = "XUC";
    public static final String COIN_TYPE_BCH = "BCH";

    /**
     * 提币
     */
    public static final String WITHDRAW = "withdraw";
    /**
     * 转账
     */
    public static final String TRANSFER = "transfer";
    /**
     * 充币
     */
    public static final String RECHARGE = "recharge";

    /**
     * 交易
     */
    public static final String TRADE = "trade";



    /**
     * BTC提币/转账手续费
     */
    public static final BigDecimal WITHDRAW_FEE_BTC = new BigDecimal("0.0005");

    /**
     * ETH提币/转账手续费
     */
    public static final BigDecimal WITHDRAW_FEE_ETH = new BigDecimal("0.01");

    /**
     * ETC提币/转账手续费
     */
    public static final BigDecimal WITHDRAW_FEE_ETC = new BigDecimal("0.01");
    /**
     * LTC提币/转账手续费
     */
    public static final BigDecimal WITHDRAW_FEE_LTC = new BigDecimal("0.001");
    /**
     * XUC提币/转账手续费 以ETH结算
     */
    public static final BigDecimal WITHDRAW_FEE_XUC = new BigDecimal("0.01");

    /**
     * BCH提币/转账手续费 以ETH结算
     */
    public static final BigDecimal WITHDRAW_FEE_BCH = new BigDecimal("0.0005");


    /**
     * BTC最小提币金额
     */
    public static final BigDecimal WITHDRAW_MIN_BTC = new BigDecimal("0.0025");
    /**
     * ETH最小提币金额
     */
    public static final BigDecimal WITHDRAW_MIN_ETH = new BigDecimal("0.01");
    /**
     * ETC最小提币金额
     */
    public static final BigDecimal WITHDRAW_MIN_ETC = new BigDecimal("0.01");
    /**
     * LTC最小提币金额
     */
    public static final BigDecimal WITHDRAW_MIN_LTC = new BigDecimal("0.01");
    /**
     * XUC最小提币金额
     */
    public static final BigDecimal WITHDRAW_MIN_XUC = new BigDecimal("0.5");
    /**
     * BCH最小提币金额
     */
    public static final BigDecimal WITHDRAW_MIN_BCH = new BigDecimal("0.01");

    /**
     * 币种小数点后位数
     */
    public static final int COIN_DECIMAL_DIGITS = 8;

    /**
     * 现价单
     */
    public static final String TRADE_LIMIT = "LIMIT";

    /**
     * 市价单
     */
    public static final String TRADE_MARKET = "MARKET";
    /**
     * 买单
     */
    public static final String TRADE_BUY = "BUY";
    /**
     * 卖单
     */
    public static final String TRADE_SELL = "SELL";


    /**
     * 交易对
     */
    public static final String MARKET_TYPE = "market_type";

    /**
     * Socket Url
     */
    public static final String SOCKET_MARKET_URL = BuildConfig.SOCKET_HOST;

    /**
     * 是否打印Log
     */
    public static boolean LOG_DEBUG = BuildConfig.LOG_DEBUG;


}
