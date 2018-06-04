package cn.meihua.mvp_dagger2_rxjava2_demo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by meih on 2017/7/12.
 */

public class WordJsonBean {


    /**
     * resourcetype : zh_cn
     * version : 1.2.0.44
     * error_massage : {"CAPTCHA_MISSING":"缺失图形验证码","DUPLICATED_TXID":"重复的 TXID","DUPLICATE_TXID":"又是重复的 TXID","EMAIL_EXISTED":"邮箱账号已存在","EMAIL_REGISTERED":"邮箱账号已注册","INSUFFICIENT_BALANCE":"账户资金不足","INSUFFICIENT_MARKET_DEPTH":"市场深度不够","INTERNAL_ERROR":"客户端异常","INVALID_CAPTCHA":"图形验证码有误","INVALID_EMAIL":"邮箱地址无效","INVALID_FLOW":"FLOW 无效","INVALID_FLOW_STEP":"FLOW 步骤无效","INVALID_KYC_REVIEW_JOB":"无效的 KYC 审核任务","INVALID_MARKET":"无效的市场","INVALID_OLD_PASSWORD":"原密码错误","INVALID_OLD_TRADE_PASSWORD":"原交易密码输入错误","INVALID_PHONE":"手机号码无效","INVALID_PREVIOUS_KYC_STATUS":"KYC状态无效","INVALID_TRADE_PASSWORD":"交易密码无效","INVALID_USAGE":"用途无效","INVALID_VCODE":"验证码不匹配","KYC_AGE_ABOVE_SEVENTY":"身份验证的年龄大于 70 岁","KYC_AGE_UNDER_EIGHTEEN":"身份验证的年龄低于 18 岁","KYC_BANK_ACCOUNT_ALREADY_BOUND":"身份验证银行卡已被其他账户绑定","KYC_DOWNGRADE_FORBIDDEN":"无法做降级身份验证","KYC_ID_CARD_ALREADY_BOUND":"身份验证居民身份证号已被其他账户绑定","KYC_ID_CARD_LENGTH_INVALID":"身份验证的身份证长度无效","KYC_LV1_API_INVOKING_EXCEPTION":"身份验证等级一第三方 API 调用失败","KYC_LV1_PENDING":"身份验证等级一审核中","KYC_LV1_REJECTED":"身份验证等级一审核失败","KYC_LV2_PENDING":"身份验证等级二审核中","KYC_LV3_PENDING":"身份验证等级三审核中","KYC_PHONE_ALREADY_BOUND":"身份验证手机号已经被其他帐号绑定","KYC_PHONE_DIFFERENT_WITH_REGISTER_PHONE":"身份验证手机号与注册手机号不同","KYC_PREVIOUS_STATUS_INVALID":"[罕见错误]身份验证的当前状态无权调用此接口","MARKET_CLOSED":"市场未开放","MISSING_VCODE":"请输入验证码","NEED_CAPTCHA":"请输入图形验证码","NEED_PHONE":"请输入手机号","NO_SUCH_USER":"账户不存在","NO_TRADE_PASSWORD":"没有交易密码","PASSWORD_ERROR":"交易密码输入有误","PHONE_EXISTED":"手机号已存在","QQ_LOGIN_FAILED":"QQ 登录失败","ROLE_UNKNOWN":"未知角色","SECURITY_RISK":"安全风险","TRADE_PASSWORD_CONFIRMATION_EXPIRED":"交易密码确认已过期，请重新确认","TRADE_PASSWORD_EXISTED":"已设置过交易密码","UNKNOWN_BLACKLIST_TYPE":"未知的黑名单类型","UNKNOWN_EMIAL_TEMPLATE":"未知的邮箱模板","UNKNOWN_JUDGEMENT":"未知的评判","UNKNOWN_SMS_TEMPLATE":"未知的短信模板","UNSUPPORTED_METHOD":"不支持的方法","UNSUPPORTED_OAUTH2_PROVIDER":"不支持的第三方登录提供商","VCODE_NOT_FOUND":"请重新获取验证码","INVALID_GOOGLE_CODE":"请重新输入google验证码","PHONE_NOT_SUPPORTED_WHEN_EMAIL_EXISTS":"邮箱存在时不能通过手机验证","EMAIL_NOT_BOUND":"邮箱未绑定","MESSAGE_NOT_FOUND":"站内信不存在","AUTHORITY_NOT_QUALIFIED":"无权限","NICKNAME_EXISTED":"昵称已存在","NICKNAME_NOT_QUALIFIED":"昵称不符合要求","VCODE_TRY_TIMES_EXCEED_LIMIT":"验证码尝试次数超过限制","EXISTED_EMAIL":"该email已经被绑定","IMAGE_FORMAT_CONVERSION_ERROR":"不支持的图片格式","FREEZE_FAILS":"提现冻结操作失败","ACCOUNT_NULL":"账户为null","WITHDRAW_FAIL":"提现操作失败","CREATE_WITHDRAW_ORDER_FAIL":"创建提现订单失败","ADDRESS_IS_NULL":"虚拟货币地址为null","PARAMRES_NULL":"参数为null","MULTIIPLE_ACCOUNT":"请求的银行账号数过多","NO_ACCOUNT":"请求中不包含银行账号","INVALID_PRICE":"请输入正确的价格","INVALID_QUANTITY":"请输入正确的数量","UNSUPPORTED_CONTRACT":"不支持的交易合约","UNSUPPORTED_ORDER_TYPE":"不支持的订单类型","TOO_LATE_TO_CANCEL":"订单已完成","ALREADY_CANCELLED":"订单已撤销","ACCOUNT_NOT_EXIST":"账户不存在","PLACE_ORDER_RESPONSE_TIMEOUT":"服务器内部错误请及时联系客服","CANCEL_ORDER_RESPONSE_TIMEOUT":"服务器内部错误请及时联系客服","TRADE_ENGINE_DOWN":"服务器内部错误请及时联系客服","ACCOUNT_SERVICE_RUNTIME_ERROR":"服务器内部错误请及时联系客服","ACCOUNT_SERVICE_DOWN":"服务器内部错误请及时联系客服","UNEXPECTED_PLACE_ORDER_EXCEPTION":"服务器内部错误请及时联系客服","TRADE_ENGINE_BUSY":"服务器内部错误请及时联系客服","ACCOUNT_SERVICE_BUSY":"服务器内部错误请及时联系客服","binding_code_expired":"验证码已失效，请重新发送","binding_method_prompt":"请客户端提示用户输入绑定验证码","server_internal_error":"服务器内部错误，请重试","invalid_grant":"授权无效","invalid_mfa_token":"二次验证失效","invalid_mfa_token_status":"状态错误","limit_exceeded":"验证码5次输入错误，请重新发送","mfa_required":"需要二次验证","unsupported_challenge_type":"不支持的MFA授权方式","INVALID_ARGUMENTS":"输入不合规"}
     * localization : {"wallet":"资产","dae_wallet":"数字资产","email_account":"邮箱账户","no_such_email_account":"邮箱账户不存在","login_passcode":"登录密码","forget_login_passcode":"忘记密码","login_button":"登录","sign_up_button":"免费注册","sign_up":"注册","set_account":"设置账户","account_complete":"账户信息完善","sign_up_reminder1":"请设置在我平台的用户昵称","sign_up_reminder2":"4至20个字符，支持数字、英文和汉字","sign_up_nickname_wrong":"请输入格式正确的昵称","user_nickname":"用户昵称","account_comfirm":"账户确认","vcode":"验证码","send_vcode":"发送验证码","send_vcode_failed":"发送验证码失败","next_step":"下一步","reset_login_passcode":"重置密码","new_passcode":"输入新密码","passcode_strength":"密码强度","comfirm_passcode":"确认密码","complete":"完成","click_to_fingerprint_login":"点击进行指纹登录","use_passcode_login":"密码登录","click_consent_agreement":"点击注册即表示同意","service_name":"《DAE数字资产交易所服务协议》","signup_and_login":"注册并登录","no_beginning_set":"您尚未完成初始设置","beginning_set":"初始设置","setting_up_button":"马上设置","cancel_button":"取消","wallet_name":"资产名称","capital_code":"资金密码","set_capital_code_rule":"输入6位数字资金密码","comfirm_capital_code":"确认资金密码","choose_virtual_asset":"选择资产种类","btc":"BTC","eth":"ETH","etc":"ETC","ltc":"LTC","xuc":"XUC","beginning_set_reminder":"资金密码设置完成，可在设置内修改","beginning_set_complete":"知道了","management_wallet":"资产管理","save":"保存","available_asset":"可用","frozen_asset":"冻结","deposit_coin":"充币","withdraw_coin":"提币","resent_record":"最近记录","order_details":"订单详情","order_number":"订单号","from_address":"来自","to_address":"提至","time":"时间","fee":"手续费","order_status":"订单状态","deposit_allcoin":"{0}充币","deposit_reminder":"请向如下地址汇入{0}完成充币","copy_address":"复制地址","withdraw_allcoin":"{0}提币","withdraw_address":"提币地址","alter":"修改","withdraw_amount":"提币数量","withdraw_complete":"提币完成","available_balance":"可用余额","no_address_yet":"尚未添加提币地址","add":"添加","need_capital_code":"请输入资金密码","address_management":"提币地址管理","allcoin_address":"{0}地址","edit_address":"编辑地址","delete_address":"删除地址","add_address":"添加地址","address_wrong":"地址不合规","address_type":"地址类型","label":"标签","email_vcode":"邮箱验证码","comfirm":"确定","profile":"我的","account_details":"账户明细","news_center":"消息中心","account_security_center":"账户安全中心","setting":"设置","about":"关于","logout":"退出","logout_comfirm":"确认退出","all":"全部","system_news":"系统消息","news_details":"消息详情","email_alter":"邮箱更改","google_verify":"谷歌验证","go_bound":"去绑定","change_email":"更换邮箱账户","bound_email":"绑定邮箱账号","old_email":"原邮箱号","new_email":"新邮箱号","touchid_login":"指纹登录","check_update":"检查更新","login_gesture_passcode":"登录手势密码","alter_capital_code":"修改资金密码","forget_capital_code":"忘记资金密码","set_capital_code":"设置资金密码","set_wallet_first":"请先完成初始设置","alter_capital_code_fisrt":"输入原始资金密码","capital_code_old_wrong":"原始资金密码错误","alter_capital_code_second":"输入新的资金密码","alter_capital_code_third":"确认新的资金密码","abandon_alter_capital_code":"确认放弃修改资金密码","abandon_alter_passcode":"确认放弃修改登录密码","abandon_reset_capital_code":"确认放弃重置资金密码","abandon_set_capital_code":"确认取消设置资金密码","abandon_beginning_set":"确认放弃初始设置","abandon_edit_address":"确认放弃地址编辑","capital_code_alter_success":"资金密码修改成功","reset_capital_code":"重置资金密码","reset_capital_code_success":"资金密码重置成功","alter_login_passcode":"修改登录密码","old_login_passcode":"旧登录密码","new_login_passcode":"新登录密码","comfirm_new_login_passcode":"确认登录密码","update_versionok_text":"目前已是最新版本","update_rightnow_button":"立即更新","update_cancel_button":"暂不更新","update_newmust_text":"发现新版本，必须更新后方可使用app，请立即更新","update_download_text":"正在下载新版本，请稍后","hide_button":"隐藏","set_gesture_passcode":"设置手势密码","draw_unlock_picture":"绘制解锁图案","draw_unlock_picture_comfirm":"确认绘制解锁图案","temporarily_not_set":"暂不设置","version":"版本","service_tel":"客服电话","service_tel_number":"400-878-0015","domain_web":"www.dae.org","operation_timeout":"操作超时","capital_safty_setting":"资金安全设置","touchid_for_withdraw":"勾选touchid后，可以使用指纹代替资金密码","safty_verify_reminder":"必须包含一个或以上的安全验证方式","loading":"加载中","push_loadmore_data":"上拉加载更多","pull_refresh":"下拉刷新","is_refreshing":"正在刷新","release_refresh":"松开刷新","release_loadmore":"松开加载","strong":"强","normal":"中","weak":"弱","passcode_errors_input_again":"两次输入的密码不一致，请重新输入","capitalcode_errors_input_again":"两次输入的资金密码不一致，请重新输入","account_input_wrong":"请输入正确的邮箱账号","login_no_content":"请输入邮箱账户","error_vcode_send":"验证码发送失败","vcode_sentalready_text":"秒后重新发送","no_more_data":"没有更多数据了","no_passcode":"请输入登录密码","google_verify_code":"谷歌验证码","google_verify_code_empty":"请输入谷歌验证码","email_code_empty":"请输入邮箱验证码","capital_safty_information_empty":"请输入资金安全信息","passcode_not_inlow":"登录密码请输入6至32位字符","language_button":"语言选择","simplified_chinese":"简体中文","english":"English","management":"管理","bind_google_first":"请先在官网绑定谷歌验证器","open_fringerprint_first":"需要开启手机指纹功能","photo_album_right":"需要相机和相册权限","network_access":"需要网络访问权限","head_portrait":"头像","upload_picture":"上传头像","nick_name":"昵称","edit_data":"编辑资料","take_picture":"拍照","choose_picture_from_album":"从手机相册选择","input_nick_name":"输入昵称","comfirm_alter":"确认修改","view":"查看","set_default":"设为默认","defaultx":"默认","already_set":"已设置","not_yet_set":"未设置","vcode_wrong":"验证码输入有误","email_change_success":"邮箱更换成功","pull_to_refresh":"下拉刷新","load_more":"加载更多","no_record":"暂无记录","welcome_back":"欢迎回来","operation_failure":"操作失败","touchid_reminder_title":"\u201cDAE数字交易所\u201d的指纹登录","touchid_reminder_text":"需要指纹验证确认您的身份","touchid_failure":"指纹验证失败，请使用密码登录","comfirm_close_fingerprint":"确认关闭指纹登录","finger_print_on":"指纹登录已开启","finger_print_close":"指纹登录已关闭","qrcode_scan_camera_right":"二维码扫码需要相机权限","scan_qr_failure":"扫码失败","please_wait":"请稍后","copy_success":"复制成功","internet_error":"网络异常","no_news_yet":"暂无消息记录","delete":"删除","all_read":"全部已读","address":"地址","send_already":"已发送{0}","copyright":"©️2017-2020 DAE版权所有","withdrawl_mini":"提币数量必须大于{0}","withdrawl_max":"提币数量超过最大限额","withdrawl_failure":"提币失败","address_add_failure":"地址添加失败","address_add_success":"地址添加成功","withdrawl_address_wrong":"提币地址不正确","login_passcode_alter_success":"登录密码修改成功","vcode_send_success":"验证码发送成功","login_passcode_reset_success":"密码重置成功","email_sign_up_already":"邮箱已注册","nickname_change_success":"昵称修改成功","picture_upload_success":"头像上传成功","fingerprint_not_match":"指纹不匹配","fingerprint_failed_too_much":"指纹匹配失败次数过多","no_fingerprint_right":"没有指纹识别权限","fingerprint_no_find":"未发现指纹识别功能","no_take_fingerprint":"未录入指纹","fingerprint_not_open":"未启用指纹功能","trade":"交易","market_trade":"市价","limit_trade":"限价","order_in_trade":"委托","history_order":"历史委托","current_order":"当前委托","price":"价格","amount":"数量","buy_trade":"买入","sell_trade":"卖出","total":"总计","cancel_order":"撤单","entrusted_price":"委托价","entrusted_amount":"委托量","deal_amount":"成交量","choose_market":"选择交易市场","limit_trade_amount":"最小交易量{0}","input_price_right":"请输入正确的价格","input_amount_right":"请输入正确的数量","cancel_success":"撤单成功","cancel_fail":"撤单失败","balance_not_enough":"可用余额不足","markets":"行情","rise_fall":"涨跌","reference_price":"参考价","subject_to_market":"以市场价格为准","zero_asset":"零资产","total_asset_equal_to":"总资产（折合BTC）：","equal_to":"折合","coin_type":"币种","two_different_gestures":"两次手势不一致","too_less_gestures":"至少连接6个点","change_gestures":"修改手势密码","input_gestures":"输入手势密码","2FA":"二次验证","SMS_authentication":"短信验证","SMS_code":"短信验证码","need_sms_vcode":"请输入短信验证码","version_name":"版本号","gesture_wrong":"手势错误，还有{0}次机会","gesture_wrong_nolimit":"手势密码错误","fingerprint_wrong":"指纹错误，还有{0}次机会","average":"平均成交价","order_make_success":"下单成功","confirm":"确认","turn_on":"开启","turn_off":"关闭","choose_one_only":"只能开启指纹登录或手势登录之一","gesture_login":"手势登录","gesture_change_success":"手势修改成功","update_new_version":"发现新版本","go_web_set_2fa":"请前往官网设置二次验证","trade_type":"交易类型","child_order":"子订单","deal_price":"成交价","in_review":"审核中","review_success":"审核成功","review_failure":"审核失败","comfirming":"确认中","already_done":"完全成交","cancel_order_order":"已撤销","unfilled_order":"部分成交","alter_address_successs":"修改地址成功","alter_address_failure":"修改地址失败","not_open":"未开启","already_open":"已开启","withdral_audit":"提币请求已提交","read_write_access":"需要读写文件权限","finger_print_error":"指纹功能不可用","MISSING_label":"缺少标签说明","Maximum_vol":"最大交易量","Minimum_vol":"最小交易量","Maximum_amount":"最大交易额","Minimum_amount":"最小交易额","lower_minimum_amount":"交易金额低于最小交易额{0}","higher_maximum_amount":"交易金额高于最大交易额{0}","lower_minimum_vol":"交易量低于最小交易量{0}","higher_maximum_vol":"交易量高于最大交易量{0}","day_rise_fall":"当日涨跌","last_price":"最新价","name":"名称","one_min":"1分","five_mins":"5分","fifteen_mins":"15分","thirty_mins":"30分","one_hour":"1小时","three_hour":"3小时","six_hour":"6小时","twelve_hour":"12小时","one_day":"1日","one_week":"1周","index":"指标","master_map":"主图","sub_map":"幅图","moving_average":"MA","bollinger_bands":"BOLL","exponential_moving_average":"EMA","ma_convergence_divergence":"MACD","relative_strength_index":"RSI","jump_into_app":"跳过广告","address_not_save":"是否需要保存此次使用的提币地址","address_is_empty":"请输入提币地址","withdrawl_count_is_empty":"请输入提币数量","request_error":"请求错误"}
     * OTC : {"OTC_price":"价格","OTC_amount":"数量","OTC_buy_trade":"买入","OTC_sell_trade":"卖出","OTC_coin_type":"币种","OTC_rise_fall":"涨跌幅","OTC_customer_name":"交易对手姓名","OTC_OK":"知道了","OTC_close":"关闭","OTC_back":"返回","OTC_c2c_trade":"点对点交易","OTC_c2c":"点对点","OTC_order":"订单","OTC_account":"账户","OTC_buy_coin":"买币","OTC_sell_coin":"卖币","OTC_release_deal":"发布广告","OTC_my_deal":"我的广告","OTC_cny_text":"CNY","OTC_deal_times":"交易次数","OTC_limit_amount":"限额","OTC_repeat_order":"重复下单","OTC_repeat_order_reminder":"您尚有一个未完成订单，请勿重复下单","OTC_no_deal_right":"当日取消交易次数已满3次，请明日再进行交易","OTC_need_KYC_level":"需要通过KYC1级才能开始点对点交易","OTC_go_KYC":"去认证","OTC_cancle":"取消","OTC_doing_deals":"进行中","OTC_off_shelves":"已下架","OTC_deal_detail":"广告详情","OTC_deal_number":"广告编号","OTC_need_bound_payway":"需要绑定支付方式，方可进行交易","OTC_deal_ditails":"广告详情","OTC_entrusted_sell":"委托卖出","OTC_entrusted_amount":"委托量","OTC_deal_amount":"成交量","OTC_filled_amount":"成交金额","OTC_entrusted_time":"委托时间","OTC_total_price":"总金额","OTC_completion_text":"完成率","OTC_trade_violation":"交易违规","OTC_collect_way":"收款方式","OTC_submit_order":"下单","OTC_send_requesting":"发送请求中","OTC_submit_success":"下单成功","OTC_deal_failure_redeal":"广告失效，请重新下单","OTC_recent_index":"当前指数","OTC_coin_type_select":"币种选择","OTC_frozen_amount":"冻结数量","OTC_min_order_amount":"最小交易金额","OTC_max_order_amount":"最大交易金额","OTC_pay_way":"支付方式","OTC_repeat_deal":"当前币种已有一笔同类型广告。/如需继续发布，请等待当前交易单完成/或撤单后再次尝试。","OTC_release_success":"发布成功","OTC_confirm_release":"确定发布","OTC_to_bound":"点击前往","OTC_need_more_KYC_level":"无法发布广告,需要通过KYC2认证","OTC_KYC_certification_page":"KYC认证页面","OTC_order_status":"状态","OTC_countdown":"倒计时","OTC_unfinished_order":"未完成","OTC_history":"历史","OTC_create_order_time":"创建时间","OTC_not_paying":"未付款","OTC_wait_for_release_coin":"等待对方放币","OTC_collection_need_confirm":"收款待确认","OTC_deal_completion":"交易完成","OTC_deal_cancel":"交易取消","OTC_order_detail":"订单详情","OTC_order_num":"订单号","OTC_copy":"复制","OTC_cancle_order":"取消购买","OTC_payment_completed":"付款完成","OTC_release_coin":"确认放币","OTC_contact_customer_service":"联系客服","OTC_real_name":"实名认证","OTC_pay_note_number":"付款备注号","OTC_pay_reminder":"为了保证交易的及时性，请选择实时到账的汇款方式，例如支付宝、微信支付、银行实时汇款等。节假日或工作日的17：00-9：00，超过5万以上的汇款请分批支付，以确保到款的及时性。","OTC_confirm_cancel_order":"确定取消订单？","OTC_cancel_order_reminder":"超过三笔取消订单，将被冻结当天下单权限","OTC_cancel_confirm":"确认取消","OTC_question_meet":"如遇到任何交易问题，请尽快发送邮件至：","OTC_provide_resource":"请务必提供","OTC_resource_one":"1.订单编号；","OTC_resource_two":"2.问题详细描述；","OTC_resource_three":"3.订单详情截图；","OTC_resource_four":"4.付款证明截图。","OTC_customer_need":"方便客服人员尽快确认您遇到的问题。","OTC_sorry_for_question":"客服会在24小时内与您取得联系。给您带来的不便尽请谅解。","OTC_thank_you":"谢谢！","OTC_cancel_already":"已取消","OTC_cancel_order_time":"取消时间","OTC_compelete_order_time":"完成时间","OTC_compelete_payment_time":"付款时间","OTC_input_capital_code":"请输入资金密码","OTC_forget_capital_code":"忘记资金密码","OTC_capital_code_wrong":"资金密码不正确，今日还可输入{0}次","OTC_capital_code_wrong_threeTime":"密码错误已3次，请明日再试","OTC_transfer_capital":"资金划转","OTC_capital_record":"资金记录","OTC_set_payment":"支付管理设置","OTC_otc_available_asset":"可用数量","OTC_otc_frozen_asset":"冻结数量","OTC_bankcard":"银行卡","OTC_alipay":"支付宝","OTC_bound":"已绑定","OTC_unbound":"未绑定","OTC_payment_management":"支付管理","OTC_set_bankcard_info":"银行卡设置","OTC_account_holder":"开户人","OTC_account_holder_null":"开户人为空","OTC_wrong_account_holder":"请输入正确的开户人姓名","OTC_deposit_bank":"开户银行","OTC_sub_branch":"开户支行","OTC_wrong_sub_branch":"请输入正确的开户支行","OTC_bankcard_num":"银行卡号","OTC_bankcard_num_null":"银行卡号为空","OTC_wrong_bankcard_num":"请输入正确的银行账号","OTC_bind":"绑定","OTC_cannot_modify":"您当前有发布中的广告，请等待广告完成或撤销后再尝试修改","OTC_transfer_operation":"划转操作","OTC_from":"从","OTC_transfer_to":"转至","OTC_otc_account":"法币交易账户","OTC_original_accout":"币币交易账户","OTC_all_in":"全部","OTC_transfer":"确定转入","OTC_set_alipay_info":"支付宝设置","OTC_alipay_real_name":"真实姓名","OTC_real_name_null":"真实姓名为空","OTC_wrong_real_name":"请输入正确的真实姓名","OTC_alipay_account":"支付宝账号","OTC_wrong_alipay_account":"请输入正确的支付宝账号","OTC_otc_to_original":"法币转币币","OTC_original_to_otc":"币币转法币","OTC_price_null":"价格为空","OTC_amount_null":"交易数量为空","OTC_limit_amount_over":"已超当日累计交易限额","OTC_min_limit_too_low":"最小交易限额不得低于100CNY","OTC_min_limit_too_high":"最小交易限额超过单笔交易限额","OTC_max_limit_too_low":"最大交易限额小于最小交易限额","OTC_max_limit_too_high":"最大交易限额超过单笔交易限额","OTC_payment_null":"请选择支付方式","OTC_account_not_enough":"账户余额不足","OTC_transfer_amount_null":"划转金额不得为空","OTC_convertible_amount_not_enough":"可转金额不足","OTC_name_incorrect":"请输入正确的姓名","OTC_IDno_incorrect":"请输入正确的证件号码","OTC_phone_incorrect":"请输入正确的手机号","OTC_fundpasscode_error":"资金密码错误，还有{0}次机会","OTC_fundpasscode_error_much":"密码输入错误3次，24小时后再尝试","OTC_input_incorrect":"输入不合法","OTC_alipay_incorrect":"请输入正确的支付宝账号","bank":[{"bank_name":"中国工商银行","id":"ICBC","pic":"1"},{"bank_name":"中国农业银行","id":"ABC","pic":"2"},{"bank_name":"中国银行","id":"BOC","pic":"3"},{"bank_name":"中国建设银行","id":"CCB","pic":"4"},{"bank_name":"交通银行","id":"BOCOM","pic":"5"},{"bank_name":"中国邮政储蓄银行","id":"PSBC","pic":"6"},{"bank_name":"招商银行","id":"CMB","pic":"7"},{"bank_name":"平安银行","id":"PAB","pic":"8"},{"bank_name":"广发银行","id":"CGB","pic":"9"},{"bank_name":"华夏银行","id":"HXB","pic":"10"},{"bank_name":"中国民生银行","id":"CMBC","pic":"11"},{"bank_name":"浦发银行","id":"SPDB","pic":"12"},{"bank_name":"渤海银行","id":"CBB","pic":"13"},{"bank_name":"中信银行","id":"CCITICB","pic":"14"},{"bank_name":"中国光大银行","id":"CEB","pic":"15"},{"bank_name":"上海银行","id":"BOS","pic":"16"},{"bank_name":"北京银行","id":"BOB","pic":"17"},{"bank_name":"兴业银行","id":"IB","pic":"18"},{"bank_name":"渤海银行","id":"CBB","pic":"19"}]}
     */

    public String resourcetype;
    public String version;
    public ErrorMassageBean error_massage;
    public LocalizationBean localization;
    public OTCBean OTC;

    public static class ErrorMassageBean {
        /**
         * CAPTCHA_MISSING : 缺失图形验证码
         * DUPLICATED_TXID : 重复的 TXID
         * DUPLICATE_TXID : 又是重复的 TXID
         * EMAIL_EXISTED : 邮箱账号已存在
         * EMAIL_REGISTERED : 邮箱账号已注册
         * INSUFFICIENT_BALANCE : 账户资金不足
         * INSUFFICIENT_MARKET_DEPTH : 市场深度不够
         * INTERNAL_ERROR : 客户端异常
         * INVALID_CAPTCHA : 图形验证码有误
         * INVALID_EMAIL : 邮箱地址无效
         * INVALID_FLOW : FLOW 无效
         * INVALID_FLOW_STEP : FLOW 步骤无效
         * INVALID_KYC_REVIEW_JOB : 无效的 KYC 审核任务
         * INVALID_MARKET : 无效的市场
         * INVALID_OLD_PASSWORD : 原密码错误
         * INVALID_OLD_TRADE_PASSWORD : 原交易密码输入错误
         * INVALID_PHONE : 手机号码无效
         * INVALID_PREVIOUS_KYC_STATUS : KYC状态无效
         * INVALID_TRADE_PASSWORD : 交易密码无效
         * INVALID_USAGE : 用途无效
         * INVALID_VCODE : 验证码不匹配
         * KYC_AGE_ABOVE_SEVENTY : 身份验证的年龄大于 70 岁
         * KYC_AGE_UNDER_EIGHTEEN : 身份验证的年龄低于 18 岁
         * KYC_BANK_ACCOUNT_ALREADY_BOUND : 身份验证银行卡已被其他账户绑定
         * KYC_DOWNGRADE_FORBIDDEN : 无法做降级身份验证
         * KYC_ID_CARD_ALREADY_BOUND : 身份验证居民身份证号已被其他账户绑定
         * KYC_ID_CARD_LENGTH_INVALID : 身份验证的身份证长度无效
         * KYC_LV1_API_INVOKING_EXCEPTION : 身份验证等级一第三方 API 调用失败
         * KYC_LV1_PENDING : 身份验证等级一审核中
         * KYC_LV1_REJECTED : 身份验证等级一审核失败
         * KYC_LV2_PENDING : 身份验证等级二审核中
         * KYC_LV3_PENDING : 身份验证等级三审核中
         * KYC_PHONE_ALREADY_BOUND : 身份验证手机号已经被其他帐号绑定
         * KYC_PHONE_DIFFERENT_WITH_REGISTER_PHONE : 身份验证手机号与注册手机号不同
         * KYC_PREVIOUS_STATUS_INVALID : [罕见错误]身份验证的当前状态无权调用此接口
         * MARKET_CLOSED : 市场未开放
         * MISSING_VCODE : 请输入验证码
         * NEED_CAPTCHA : 请输入图形验证码
         * NEED_PHONE : 请输入手机号
         * NO_SUCH_USER : 账户不存在
         * NO_TRADE_PASSWORD : 没有交易密码
         * PASSWORD_ERROR : 交易密码输入有误
         * PHONE_EXISTED : 手机号已存在
         * QQ_LOGIN_FAILED : QQ 登录失败
         * ROLE_UNKNOWN : 未知角色
         * SECURITY_RISK : 安全风险
         * TRADE_PASSWORD_CONFIRMATION_EXPIRED : 交易密码确认已过期，请重新确认
         * TRADE_PASSWORD_EXISTED : 已设置过交易密码
         * UNKNOWN_BLACKLIST_TYPE : 未知的黑名单类型
         * UNKNOWN_EMIAL_TEMPLATE : 未知的邮箱模板
         * UNKNOWN_JUDGEMENT : 未知的评判
         * UNKNOWN_SMS_TEMPLATE : 未知的短信模板
         * UNSUPPORTED_METHOD : 不支持的方法
         * UNSUPPORTED_OAUTH2_PROVIDER : 不支持的第三方登录提供商
         * VCODE_NOT_FOUND : 请重新获取验证码
         * INVALID_GOOGLE_CODE : 请重新输入google验证码
         * PHONE_NOT_SUPPORTED_WHEN_EMAIL_EXISTS : 邮箱存在时不能通过手机验证
         * EMAIL_NOT_BOUND : 邮箱未绑定
         * MESSAGE_NOT_FOUND : 站内信不存在
         * AUTHORITY_NOT_QUALIFIED : 无权限
         * NICKNAME_EXISTED : 昵称已存在
         * NICKNAME_NOT_QUALIFIED : 昵称不符合要求
         * VCODE_TRY_TIMES_EXCEED_LIMIT : 验证码尝试次数超过限制
         * EXISTED_EMAIL : 该email已经被绑定
         * IMAGE_FORMAT_CONVERSION_ERROR : 不支持的图片格式
         * FREEZE_FAILS : 提现冻结操作失败
         * ACCOUNT_NULL : 账户为null
         * WITHDRAW_FAIL : 提现操作失败
         * CREATE_WITHDRAW_ORDER_FAIL : 创建提现订单失败
         * ADDRESS_IS_NULL : 虚拟货币地址为null
         * PARAMRES_NULL : 参数为null
         * MULTIIPLE_ACCOUNT : 请求的银行账号数过多
         * NO_ACCOUNT : 请求中不包含银行账号
         * INVALID_PRICE : 请输入正确的价格
         * INVALID_QUANTITY : 请输入正确的数量
         * UNSUPPORTED_CONTRACT : 不支持的交易合约
         * UNSUPPORTED_ORDER_TYPE : 不支持的订单类型
         * TOO_LATE_TO_CANCEL : 订单已完成
         * ALREADY_CANCELLED : 订单已撤销
         * ACCOUNT_NOT_EXIST : 账户不存在
         * PLACE_ORDER_RESPONSE_TIMEOUT : 服务器内部错误请及时联系客服
         * CANCEL_ORDER_RESPONSE_TIMEOUT : 服务器内部错误请及时联系客服
         * TRADE_ENGINE_DOWN : 服务器内部错误请及时联系客服
         * ACCOUNT_SERVICE_RUNTIME_ERROR : 服务器内部错误请及时联系客服
         * ACCOUNT_SERVICE_DOWN : 服务器内部错误请及时联系客服
         * UNEXPECTED_PLACE_ORDER_EXCEPTION : 服务器内部错误请及时联系客服
         * TRADE_ENGINE_BUSY : 服务器内部错误请及时联系客服
         * ACCOUNT_SERVICE_BUSY : 服务器内部错误请及时联系客服
         * binding_code_expired : 验证码已失效，请重新发送
         * binding_method_prompt : 请客户端提示用户输入绑定验证码
         * server_internal_error : 服务器内部错误，请重试
         * invalid_grant : 授权无效
         * invalid_mfa_token : 二次验证失效
         * invalid_mfa_token_status : 状态错误
         * limit_exceeded : 验证码5次输入错误，请重新发送
         * mfa_required : 需要二次验证
         * unsupported_challenge_type : 不支持的MFA授权方式
         * INVALID_ARGUMENTS : 输入不合规
         */

        public String CAPTCHA_MISSING;
        public String DUPLICATED_TXID;
        public String DUPLICATE_TXID;
        public String EMAIL_EXISTED;
        public String EMAIL_REGISTERED;
        public String INSUFFICIENT_BALANCE;
        public String INSUFFICIENT_MARKET_DEPTH;
        public String INTERNAL_ERROR;
        public String INVALID_CAPTCHA;
        public String INVALID_EMAIL;
        public String INVALID_FLOW;
        public String INVALID_FLOW_STEP;
        public String INVALID_KYC_REVIEW_JOB;
        public String INVALID_MARKET;
        public String INVALID_OLD_PASSWORD;
        public String INVALID_OLD_TRADE_PASSWORD;
        public String INVALID_PHONE;
        public String INVALID_PREVIOUS_KYC_STATUS;
        public String INVALID_TRADE_PASSWORD;
        public String INVALID_USAGE;
        public String INVALID_VCODE;
        public String KYC_AGE_ABOVE_SEVENTY;
        public String KYC_AGE_UNDER_EIGHTEEN;
        public String KYC_BANK_ACCOUNT_ALREADY_BOUND;
        public String KYC_DOWNGRADE_FORBIDDEN;
        public String KYC_ID_CARD_ALREADY_BOUND;
        public String KYC_ID_CARD_LENGTH_INVALID;
        public String KYC_LV1_API_INVOKING_EXCEPTION;
        public String KYC_LV1_PENDING;
        public String KYC_LV1_REJECTED;
        public String KYC_LV2_PENDING;
        public String KYC_LV3_PENDING;
        public String KYC_PHONE_ALREADY_BOUND;
        public String KYC_PHONE_DIFFERENT_WITH_REGISTER_PHONE;
        public String KYC_PREVIOUS_STATUS_INVALID;
        public String MARKET_CLOSED;
        public String MISSING_VCODE;
        public String NEED_CAPTCHA;
        public String NEED_PHONE;
        public String NO_SUCH_USER;
        public String NO_TRADE_PASSWORD;
        public String PASSWORD_ERROR;
        public String PHONE_EXISTED;
        public String QQ_LOGIN_FAILED;
        public String ROLE_UNKNOWN;
        public String SECURITY_RISK;
        public String TRADE_PASSWORD_CONFIRMATION_EXPIRED;
        public String TRADE_PASSWORD_EXISTED;
        public String UNKNOWN_BLACKLIST_TYPE;
        public String UNKNOWN_EMIAL_TEMPLATE;
        public String UNKNOWN_JUDGEMENT;
        public String UNKNOWN_SMS_TEMPLATE;
        public String UNSUPPORTED_METHOD;
        public String UNSUPPORTED_OAUTH2_PROVIDER;
        public String VCODE_NOT_FOUND;
        public String INVALID_GOOGLE_CODE;
        public String PHONE_NOT_SUPPORTED_WHEN_EMAIL_EXISTS;
        public String EMAIL_NOT_BOUND;
        public String MESSAGE_NOT_FOUND;
        public String AUTHORITY_NOT_QUALIFIED;
        public String NICKNAME_EXISTED;
        public String NICKNAME_NOT_QUALIFIED;
        public String VCODE_TRY_TIMES_EXCEED_LIMIT;
        public String EXISTED_EMAIL;
        public String IMAGE_FORMAT_CONVERSION_ERROR;
        public String FREEZE_FAILS;
        public String ACCOUNT_NULL;
        public String WITHDRAW_FAIL;
        public String CREATE_WITHDRAW_ORDER_FAIL;
        public String ADDRESS_IS_NULL;
        public String PARAMRES_NULL;
        public String MULTIIPLE_ACCOUNT;
        public String NO_ACCOUNT;
        public String INVALID_PRICE;
        public String INVALID_QUANTITY;
        public String UNSUPPORTED_CONTRACT;
        public String UNSUPPORTED_ORDER_TYPE;
        public String TOO_LATE_TO_CANCEL;
        public String ALREADY_CANCELLED;
        public String ACCOUNT_NOT_EXIST;
        public String PLACE_ORDER_RESPONSE_TIMEOUT;
        public String CANCEL_ORDER_RESPONSE_TIMEOUT;
        public String TRADE_ENGINE_DOWN;
        public String ACCOUNT_SERVICE_RUNTIME_ERROR;
        public String ACCOUNT_SERVICE_DOWN;
        public String UNEXPECTED_PLACE_ORDER_EXCEPTION;
        public String TRADE_ENGINE_BUSY;
        public String ACCOUNT_SERVICE_BUSY;
        public String binding_code_expired;
        public String binding_method_prompt;
        public String server_internal_error;
        public String invalid_grant;
        public String invalid_mfa_token;
        public String invalid_mfa_token_status;
        public String limit_exceeded;
        public String mfa_required;
        public String unsupported_challenge_type;
        public String INVALID_ARGUMENTS;
    }

    public static class LocalizationBean {
        /**
         * wallet : 资产
         * dae_wallet : 数字资产
         * email_account : 邮箱账户
         * no_such_email_account : 邮箱账户不存在
         * login_passcode : 登录密码
         * forget_login_passcode : 忘记密码
         * login_button : 登录
         * sign_up_button : 免费注册
         * sign_up : 注册
         * set_account : 设置账户
         * account_complete : 账户信息完善
         * sign_up_reminder1 : 请设置在我平台的用户昵称
         * sign_up_reminder2 : 4至20个字符，支持数字、英文和汉字
         * sign_up_nickname_wrong : 请输入格式正确的昵称
         * user_nickname : 用户昵称
         * account_comfirm : 账户确认
         * vcode : 验证码
         * send_vcode : 发送验证码
         * send_vcode_failed : 发送验证码失败
         * next_step : 下一步
         * reset_login_passcode : 重置密码
         * new_passcode : 输入新密码
         * passcode_strength : 密码强度
         * comfirm_passcode : 确认密码
         * complete : 完成
         * click_to_fingerprint_login : 点击进行指纹登录
         * use_passcode_login : 密码登录
         * click_consent_agreement : 点击注册即表示同意
         * service_name : 《DAE数字资产交易所服务协议》
         * signup_and_login : 注册并登录
         * no_beginning_set : 您尚未完成初始设置
         * beginning_set : 初始设置
         * setting_up_button : 马上设置
         * cancel_button : 取消
         * wallet_name : 资产名称
         * capital_code : 资金密码
         * set_capital_code_rule : 输入6位数字资金密码
         * comfirm_capital_code : 确认资金密码
         * choose_virtual_asset : 选择资产种类
         * btc : BTC
         * eth : ETH
         * etc : ETC
         * ltc : LTC
         * xuc : XUC
         * beginning_set_reminder : 资金密码设置完成，可在设置内修改
         * beginning_set_complete : 知道了
         * management_wallet : 资产管理
         * save : 保存
         * available_asset : 可用
         * frozen_asset : 冻结
         * deposit_coin : 充币
         * withdraw_coin : 提币
         * resent_record : 最近记录
         * order_details : 订单详情
         * order_number : 订单号
         * from_address : 来自
         * to_address : 提至
         * time : 时间
         * fee : 手续费
         * order_status : 订单状态
         * deposit_allcoin : {0}充币
         * deposit_reminder : 请向如下地址汇入{0}完成充币
         * copy_address : 复制地址
         * withdraw_allcoin : {0}提币
         * withdraw_address : 提币地址
         * alter : 修改
         * withdraw_amount : 提币数量
         * withdraw_complete : 提币完成
         * available_balance : 可用余额
         * no_address_yet : 尚未添加提币地址
         * add : 添加
         * need_capital_code : 请输入资金密码
         * address_management : 提币地址管理
         * allcoin_address : {0}地址
         * edit_address : 编辑地址
         * delete_address : 删除地址
         * add_address : 添加地址
         * address_wrong : 地址不合规
         * address_type : 地址类型
         * label : 标签
         * email_vcode : 邮箱验证码
         * comfirm : 确定
         * profile : 我的
         * account_details : 账户明细
         * news_center : 消息中心
         * account_security_center : 账户安全中心
         * setting : 设置
         * about : 关于
         * logout : 退出
         * logout_comfirm : 确认退出
         * all : 全部
         * system_news : 系统消息
         * news_details : 消息详情
         * email_alter : 邮箱更改
         * google_verify : 谷歌验证
         * go_bound : 去绑定
         * change_email : 更换邮箱账户
         * bound_email : 绑定邮箱账号
         * old_email : 原邮箱号
         * new_email : 新邮箱号
         * touchid_login : 指纹登录
         * check_update : 检查更新
         * login_gesture_passcode : 登录手势密码
         * alter_capital_code : 修改资金密码
         * forget_capital_code : 忘记资金密码
         * set_capital_code : 设置资金密码
         * set_wallet_first : 请先完成初始设置
         * alter_capital_code_fisrt : 输入原始资金密码
         * capital_code_old_wrong : 原始资金密码错误
         * alter_capital_code_second : 输入新的资金密码
         * alter_capital_code_third : 确认新的资金密码
         * abandon_alter_capital_code : 确认放弃修改资金密码
         * abandon_alter_passcode : 确认放弃修改登录密码
         * abandon_reset_capital_code : 确认放弃重置资金密码
         * abandon_set_capital_code : 确认取消设置资金密码
         * abandon_beginning_set : 确认放弃初始设置
         * abandon_edit_address : 确认放弃地址编辑
         * capital_code_alter_success : 资金密码修改成功
         * reset_capital_code : 重置资金密码
         * reset_capital_code_success : 资金密码重置成功
         * alter_login_passcode : 修改登录密码
         * old_login_passcode : 旧登录密码
         * new_login_passcode : 新登录密码
         * comfirm_new_login_passcode : 确认登录密码
         * update_versionok_text : 目前已是最新版本
         * update_rightnow_button : 立即更新
         * update_cancel_button : 暂不更新
         * update_newmust_text : 发现新版本，必须更新后方可使用app，请立即更新
         * update_download_text : 正在下载新版本，请稍后
         * hide_button : 隐藏
         * set_gesture_passcode : 设置手势密码
         * draw_unlock_picture : 绘制解锁图案
         * draw_unlock_picture_comfirm : 确认绘制解锁图案
         * temporarily_not_set : 暂不设置
         * version : 版本
         * service_tel : 客服电话
         * service_tel_number : 400-878-0015
         * domain_web : www.dae.org
         * operation_timeout : 操作超时
         * capital_safty_setting : 资金安全设置
         * touchid_for_withdraw : 勾选touchid后，可以使用指纹代替资金密码
         * safty_verify_reminder : 必须包含一个或以上的安全验证方式
         * loading : 加载中
         * push_loadmore_data : 上拉加载更多
         * pull_refresh : 下拉刷新
         * is_refreshing : 正在刷新
         * release_refresh : 松开刷新
         * release_loadmore : 松开加载
         * strong : 强
         * normal : 中
         * weak : 弱
         * passcode_errors_input_again : 两次输入的密码不一致，请重新输入
         * capitalcode_errors_input_again : 两次输入的资金密码不一致，请重新输入
         * account_input_wrong : 请输入正确的邮箱账号
         * login_no_content : 请输入邮箱账户
         * error_vcode_send : 验证码发送失败
         * vcode_sentalready_text : 秒后重新发送
         * no_more_data : 没有更多数据了
         * no_passcode : 请输入登录密码
         * google_verify_code : 谷歌验证码
         * google_verify_code_empty : 请输入谷歌验证码
         * email_code_empty : 请输入邮箱验证码
         * capital_safty_information_empty : 请输入资金安全信息
         * passcode_not_inlow : 登录密码请输入6至32位字符
         * language_button : 语言选择
         * simplified_chinese : 简体中文
         * english : English
         * management : 管理
         * bind_google_first : 请先在官网绑定谷歌验证器
         * open_fringerprint_first : 需要开启手机指纹功能
         * photo_album_right : 需要相机和相册权限
         * network_access : 需要网络访问权限
         * head_portrait : 头像
         * upload_picture : 上传头像
         * nick_name : 昵称
         * edit_data : 编辑资料
         * take_picture : 拍照
         * choose_picture_from_album : 从手机相册选择
         * input_nick_name : 输入昵称
         * comfirm_alter : 确认修改
         * view : 查看
         * set_default : 设为默认
         * defaultx : 默认
         * already_set : 已设置
         * not_yet_set : 未设置
         * vcode_wrong : 验证码输入有误
         * email_change_success : 邮箱更换成功
         * pull_to_refresh : 下拉刷新
         * load_more : 加载更多
         * no_record : 暂无记录
         * welcome_back : 欢迎回来
         * operation_failure : 操作失败
         * touchid_reminder_title : “DAE数字交易所”的指纹登录
         * touchid_reminder_text : 需要指纹验证确认您的身份
         * touchid_failure : 指纹验证失败，请使用密码登录
         * comfirm_close_fingerprint : 确认关闭指纹登录
         * finger_print_on : 指纹登录已开启
         * finger_print_close : 指纹登录已关闭
         * qrcode_scan_camera_right : 二维码扫码需要相机权限
         * scan_qr_failure : 扫码失败
         * please_wait : 请稍后
         * copy_success : 复制成功
         * internet_error : 网络异常
         * no_news_yet : 暂无消息记录
         * delete : 删除
         * all_read : 全部已读
         * address : 地址
         * send_already : 已发送{0}
         * copyright : ©️2017-2020 DAE版权所有
         * withdrawl_mini : 提币数量必须大于{0}
         * withdrawl_max : 提币数量超过最大限额
         * withdrawl_failure : 提币失败
         * address_add_failure : 地址添加失败
         * address_add_success : 地址添加成功
         * withdrawl_address_wrong : 提币地址不正确
         * login_passcode_alter_success : 登录密码修改成功
         * vcode_send_success : 验证码发送成功
         * login_passcode_reset_success : 密码重置成功
         * email_sign_up_already : 邮箱已注册
         * nickname_change_success : 昵称修改成功
         * picture_upload_success : 头像上传成功
         * fingerprint_not_match : 指纹不匹配
         * fingerprint_failed_too_much : 指纹匹配失败次数过多
         * no_fingerprint_right : 没有指纹识别权限
         * fingerprint_no_find : 未发现指纹识别功能
         * no_take_fingerprint : 未录入指纹
         * fingerprint_not_open : 未启用指纹功能
         * trade : 交易
         * market_trade : 市价
         * limit_trade : 限价
         * order_in_trade : 委托
         * history_order : 历史委托
         * current_order : 当前委托
         * price : 价格
         * amount : 数量
         * buy_trade : 买入
         * sell_trade : 卖出
         * total : 总计
         * cancel_order : 撤单
         * entrusted_price : 委托价
         * entrusted_amount : 委托量
         * deal_amount : 成交量
         * choose_market : 选择交易市场
         * limit_trade_amount : 最小交易量{0}
         * input_price_right : 请输入正确的价格
         * input_amount_right : 请输入正确的数量
         * cancel_success : 撤单成功
         * cancel_fail : 撤单失败
         * balance_not_enough : 可用余额不足
         * markets : 行情
         * rise_fall : 涨跌
         * reference_price : 参考价
         * subject_to_market : 以市场价格为准
         * zero_asset : 零资产
         * total_asset_equal_to : 总资产（折合BTC）：
         * equal_to : 折合
         * coin_type : 币种
         * two_different_gestures : 两次手势不一致
         * too_less_gestures : 至少连接6个点
         * change_gestures : 修改手势密码
         * input_gestures : 输入手势密码
         * 2FA : 二次验证
         * SMS_authentication : 短信验证
         * SMS_code : 短信验证码
         * need_sms_vcode : 请输入短信验证码
         * version_name : 版本号
         * gesture_wrong : 手势错误，还有{0}次机会
         * gesture_wrong_nolimit : 手势密码错误
         * fingerprint_wrong : 指纹错误，还有{0}次机会
         * average : 平均成交价
         * order_make_success : 下单成功
         * confirm : 确认
         * turn_on : 开启
         * turn_off : 关闭
         * choose_one_only : 只能开启指纹登录或手势登录之一
         * gesture_login : 手势登录
         * gesture_change_success : 手势修改成功
         * update_new_version : 发现新版本
         * go_web_set_2fa : 请前往官网设置二次验证
         * trade_type : 交易类型
         * child_order : 子订单
         * deal_price : 成交价
         * in_review : 审核中
         * review_success : 审核成功
         * review_failure : 审核失败
         * comfirming : 确认中
         * already_done : 完全成交
         * cancel_order_order : 已撤销
         * unfilled_order : 部分成交
         * alter_address_successs : 修改地址成功
         * alter_address_failure : 修改地址失败
         * not_open : 未开启
         * already_open : 已开启
         * withdral_audit : 提币请求已提交
         * read_write_access : 需要读写文件权限
         * finger_print_error : 指纹功能不可用
         * MISSING_label : 缺少标签说明
         * Maximum_vol : 最大交易量
         * Minimum_vol : 最小交易量
         * Maximum_amount : 最大交易额
         * Minimum_amount : 最小交易额
         * lower_minimum_amount : 交易金额低于最小交易额{0}
         * higher_maximum_amount : 交易金额高于最大交易额{0}
         * lower_minimum_vol : 交易量低于最小交易量{0}
         * higher_maximum_vol : 交易量高于最大交易量{0}
         * day_rise_fall : 当日涨跌
         * last_price : 最新价
         * name : 名称
         * one_min : 1分
         * five_mins : 5分
         * fifteen_mins : 15分
         * thirty_mins : 30分
         * one_hour : 1小时
         * three_hour : 3小时
         * six_hour : 6小时
         * twelve_hour : 12小时
         * one_day : 1日
         * one_week : 1周
         * index : 指标
         * master_map : 主图
         * sub_map : 幅图
         * moving_average : MA
         * bollinger_bands : BOLL
         * exponential_moving_average : EMA
         * ma_convergence_divergence : MACD
         * relative_strength_index : RSI
         * jump_into_app : 跳过广告
         * address_not_save : 是否需要保存此次使用的提币地址
         * address_is_empty : 请输入提币地址
         * withdrawl_count_is_empty : 请输入提币数量
         * request_error : 请求错误
         */

        public String wallet;
        public String dae_wallet;
        public String email_account;
        public String no_such_email_account;
        public String login_passcode;
        public String forget_login_passcode;
        public String login_button;
        public String sign_up_button;
        public String sign_up;
        public String set_account;
        public String account_complete;
        public String sign_up_reminder1;
        public String sign_up_reminder2;
        public String sign_up_nickname_wrong;
        public String user_nickname;
        public String account_comfirm;
        public String vcode;
        public String send_vcode;
        public String send_vcode_failed;
        public String next_step;
        public String reset_login_passcode;
        public String new_passcode;
        public String passcode_strength;
        public String comfirm_passcode;
        public String complete;
        public String click_to_fingerprint_login;
        public String use_passcode_login;
        public String click_consent_agreement;
        public String service_name;
        public String signup_and_login;
        public String no_beginning_set;
        public String beginning_set;
        public String setting_up_button;
        public String cancel_button;
        public String wallet_name;
        public String capital_code;
        public String set_capital_code_rule;
        public String comfirm_capital_code;
        public String choose_virtual_asset;
        public String btc;
        public String eth;
        public String etc;
        public String ltc;
        public String xuc;
        public String beginning_set_reminder;
        public String beginning_set_complete;
        public String management_wallet;
        public String save;
        public String available_asset;
        public String frozen_asset;
        public String deposit_coin;
        public String withdraw_coin;
        public String resent_record;
        public String order_details;
        public String order_number;
        public String from_address;
        public String to_address;
        public String time;
        public String fee;
        public String order_status;
        public String deposit_allcoin;
        public String deposit_reminder;
        public String copy_address;
        public String withdraw_allcoin;
        public String withdraw_address;
        public String alter;
        public String withdraw_amount;
        public String withdraw_complete;
        public String available_balance;
        public String no_address_yet;
        public String add;
        public String need_capital_code;
        public String address_management;
        public String allcoin_address;
        public String edit_address;
        public String delete_address;
        public String add_address;
        public String address_wrong;
        public String address_type;
        public String label;
        public String email_vcode;
        public String comfirm;
        public String profile;
        public String account_details;
        public String news_center;
        public String account_security_center;
        public String setting;
        public String about;
        public String logout;
        public String logout_comfirm;
        public String all;
        public String system_news;
        public String news_details;
        public String email_alter;
        public String google_verify;
        public String go_bound;
        public String change_email;
        public String bound_email;
        public String old_email;
        public String new_email;
        public String touchid_login;
        public String check_update;
        public String login_gesture_passcode;
        public String alter_capital_code;
        public String forget_capital_code;
        public String set_capital_code;
        public String set_wallet_first;
        public String alter_capital_code_fisrt;
        public String capital_code_old_wrong;
        public String alter_capital_code_second;
        public String alter_capital_code_third;
        public String abandon_alter_capital_code;
        public String abandon_alter_passcode;
        public String abandon_reset_capital_code;
        public String abandon_set_capital_code;
        public String abandon_beginning_set;
        public String abandon_edit_address;
        public String capital_code_alter_success;
        public String reset_capital_code;
        public String reset_capital_code_success;
        public String alter_login_passcode;
        public String old_login_passcode;
        public String new_login_passcode;
        public String comfirm_new_login_passcode;
        public String update_versionok_text;
        public String update_rightnow_button;
        public String update_cancel_button;
        public String update_newmust_text;
        public String update_download_text;
        public String hide_button;
        public String set_gesture_passcode;
        public String draw_unlock_picture;
        public String draw_unlock_picture_comfirm;
        public String temporarily_not_set;
        public String version;
        public String service_tel;
        public String service_tel_number;
        public String domain_web;
        public String operation_timeout;
        public String capital_safty_setting;
        public String touchid_for_withdraw;
        public String safty_verify_reminder;
        public String loading;
        public String push_loadmore_data;
        public String pull_refresh;
        public String is_refreshing;
        public String release_refresh;
        public String release_loadmore;
        public String strong;
        public String normal;
        public String weak;
        public String passcode_errors_input_again;
        public String capitalcode_errors_input_again;
        public String account_input_wrong;
        public String login_no_content;
        public String error_vcode_send;
        public String vcode_sentalready_text;
        public String no_more_data;
        public String no_passcode;
        public String google_verify_code;
        public String google_verify_code_empty;
        public String email_code_empty;
        public String capital_safty_information_empty;
        public String passcode_not_inlow;
        public String language_button;
        public String simplified_chinese;
        public String english;
        public String management;
        public String bind_google_first;
        public String open_fringerprint_first;
        public String photo_album_right;
        public String network_access;
        public String head_portrait;
        public String upload_picture;
        public String nick_name;
        public String edit_data;
        public String take_picture;
        public String choose_picture_from_album;
        public String input_nick_name;
        public String comfirm_alter;
        public String view;
        public String set_default;
        public String defaultx;
        public String already_set;
        public String not_yet_set;
        public String vcode_wrong;
        public String email_change_success;
        public String pull_to_refresh;
        public String load_more;
        public String no_record;
        public String welcome_back;
        public String operation_failure;
        public String touchid_reminder_title;
        public String touchid_reminder_text;
        public String touchid_failure;
        public String comfirm_close_fingerprint;
        public String finger_print_on;
        public String finger_print_close;
        public String qrcode_scan_camera_right;
        public String scan_qr_failure;
        public String please_wait;
        public String copy_success;
        public String internet_error;
        public String no_news_yet;
        public String delete;
        public String all_read;
        public String address;
        public String send_already;
        public String copyright;
        public String withdrawl_mini;
        public String withdrawl_max;
        public String withdrawl_failure;
        public String address_add_failure;
        public String address_add_success;
        public String withdrawl_address_wrong;
        public String login_passcode_alter_success;
        public String vcode_send_success;
        public String login_passcode_reset_success;
        public String email_sign_up_already;
        public String nickname_change_success;
        public String picture_upload_success;
        public String fingerprint_not_match;
        public String fingerprint_failed_too_much;
        public String no_fingerprint_right;
        public String fingerprint_no_find;
        public String no_take_fingerprint;
        public String fingerprint_not_open;
        public String trade;
        public String market_trade;
        public String limit_trade;
        public String order_in_trade;
        public String history_order;
        public String current_order;
        public String price;
        public String amount;
        public String buy_trade;
        public String sell_trade;
        public String total;
        public String cancel_order;
        public String entrusted_price;
        public String entrusted_amount;
        public String deal_amount;
        public String choose_market;
        public String limit_trade_amount;
        public String input_price_right;
        public String input_amount_right;
        public String cancel_success;
        public String cancel_fail;
        public String balance_not_enough;
        public String markets;
        public String rise_fall;
        public String reference_price;
        public String subject_to_market;
        public String zero_asset;
        public String total_asset_equal_to;
        public String equal_to;
        public String coin_type;
        public String two_different_gestures;
        public String too_less_gestures;
        public String change_gestures;
        public String input_gestures;
        @SerializedName("2FA")
        public String _$2FA;
        public String SMS_authentication;
        public String SMS_code;
        public String need_sms_vcode;
        public String version_name;
        public String gesture_wrong;
        public String gesture_wrong_nolimit;
        public String fingerprint_wrong;
        public String average;
        public String order_make_success;
        public String confirm;
        public String turn_on;
        public String turn_off;
        public String choose_one_only;
        public String gesture_login;
        public String gesture_change_success;
        public String update_new_version;
        public String go_web_set_2fa;
        public String trade_type;
        public String child_order;
        public String deal_price;
        public String in_review;
        public String review_success;
        public String review_failure;
        public String comfirming;
        public String already_done;
        public String cancel_order_order;
        public String unfilled_order;
        public String alter_address_successs;
        public String alter_address_failure;
        public String not_open;
        public String already_open;
        public String withdral_audit;
        public String read_write_access;
        public String finger_print_error;
        public String MISSING_label;
        public String Maximum_vol;
        public String Minimum_vol;
        public String Maximum_amount;
        public String Minimum_amount;
        public String lower_minimum_amount;
        public String higher_maximum_amount;
        public String lower_minimum_vol;
        public String higher_maximum_vol;
        public String day_rise_fall;
        public String last_price;
        public String name;
        public String one_min;
        public String five_mins;
        public String fifteen_mins;
        public String thirty_mins;
        public String one_hour;
        public String three_hour;
        public String six_hour;
        public String twelve_hour;
        public String one_day;
        public String one_week;
        public String index;
        public String master_map;
        public String sub_map;
        public String moving_average;
        public String bollinger_bands;
        public String exponential_moving_average;
        public String ma_convergence_divergence;
        public String relative_strength_index;
        public String jump_into_app;
        public String address_not_save;
        public String address_is_empty;
        public String withdrawl_count_is_empty;
        public String request_error;
    }

    public static class OTCBean {
        /**
         * OTC_price : 价格
         * OTC_amount : 数量
         * OTC_buy_trade : 买入
         * OTC_sell_trade : 卖出
         * OTC_coin_type : 币种
         * OTC_rise_fall : 涨跌幅
         * OTC_customer_name : 交易对手姓名
         * OTC_OK : 知道了
         * OTC_close : 关闭
         * OTC_back : 返回
         * OTC_c2c_trade : 点对点交易
         * OTC_c2c : 点对点
         * OTC_order : 订单
         * OTC_account : 账户
         * OTC_buy_coin : 买币
         * OTC_sell_coin : 卖币
         * OTC_release_deal : 发布广告
         * OTC_my_deal : 我的广告
         * OTC_cny_text : CNY
         * OTC_deal_times : 交易次数
         * OTC_limit_amount : 限额
         * OTC_repeat_order : 重复下单
         * OTC_repeat_order_reminder : 您尚有一个未完成订单，请勿重复下单
         * OTC_no_deal_right : 当日取消交易次数已满3次，请明日再进行交易
         * OTC_need_KYC_level : 需要通过KYC1级才能开始点对点交易
         * OTC_go_KYC : 去认证
         * OTC_cancle : 取消
         * OTC_doing_deals : 进行中
         * OTC_off_shelves : 已下架
         * OTC_deal_detail : 广告详情
         * OTC_deal_number : 广告编号
         * OTC_need_bound_payway : 需要绑定支付方式，方可进行交易
         * OTC_deal_ditails : 广告详情
         * OTC_entrusted_sell : 委托卖出
         * OTC_entrusted_amount : 委托量
         * OTC_deal_amount : 成交量
         * OTC_filled_amount : 成交金额
         * OTC_entrusted_time : 委托时间
         * OTC_total_price : 总金额
         * OTC_completion_text : 完成率
         * OTC_trade_violation : 交易违规
         * OTC_collect_way : 收款方式
         * OTC_submit_order : 下单
         * OTC_send_requesting : 发送请求中
         * OTC_submit_success : 下单成功
         * OTC_deal_failure_redeal : 广告失效，请重新下单
         * OTC_recent_index : 当前指数
         * OTC_coin_type_select : 币种选择
         * OTC_frozen_amount : 冻结数量
         * OTC_min_order_amount : 最小交易金额
         * OTC_max_order_amount : 最大交易金额
         * OTC_pay_way : 支付方式
         * OTC_repeat_deal : 当前币种已有一笔同类型广告。/如需继续发布，请等待当前交易单完成/或撤单后再次尝试。
         * OTC_release_success : 发布成功
         * OTC_confirm_release : 确定发布
         * OTC_to_bound : 点击前往
         * OTC_need_more_KYC_level : 无法发布广告,需要通过KYC2认证
         * OTC_KYC_certification_page : KYC认证页面
         * OTC_order_status : 状态
         * OTC_countdown : 倒计时
         * OTC_unfinished_order : 未完成
         * OTC_history : 历史
         * OTC_create_order_time : 创建时间
         * OTC_not_paying : 未付款
         * OTC_wait_for_release_coin : 等待对方放币
         * OTC_collection_need_confirm : 收款待确认
         * OTC_deal_completion : 交易完成
         * OTC_deal_cancel : 交易取消
         * OTC_order_detail : 订单详情
         * OTC_order_num : 订单号
         * OTC_copy : 复制
         * OTC_cancle_order : 取消购买
         * OTC_payment_completed : 付款完成
         * OTC_release_coin : 确认放币
         * OTC_contact_customer_service : 联系客服
         * OTC_real_name : 实名认证
         * OTC_pay_note_number : 付款备注号
         * OTC_pay_reminder : 为了保证交易的及时性，请选择实时到账的汇款方式，例如支付宝、微信支付、银行实时汇款等。节假日或工作日的17：00-9：00，超过5万以上的汇款请分批支付，以确保到款的及时性。
         * OTC_confirm_cancel_order : 确定取消订单？
         * OTC_cancel_order_reminder : 超过三笔取消订单，将被冻结当天下单权限
         * OTC_cancel_confirm : 确认取消
         * OTC_question_meet : 如遇到任何交易问题，请尽快发送邮件至：
         * OTC_provide_resource : 请务必提供
         * OTC_resource_one : 1.订单编号；
         * OTC_resource_two : 2.问题详细描述；
         * OTC_resource_three : 3.订单详情截图；
         * OTC_resource_four : 4.付款证明截图。
         * OTC_customer_need : 方便客服人员尽快确认您遇到的问题。
         * OTC_sorry_for_question : 客服会在24小时内与您取得联系。给您带来的不便尽请谅解。
         * OTC_thank_you : 谢谢！
         * OTC_cancel_already : 已取消
         * OTC_cancel_order_time : 取消时间
         * OTC_compelete_order_time : 完成时间
         * OTC_compelete_payment_time : 付款时间
         * OTC_input_capital_code : 请输入资金密码
         * OTC_forget_capital_code : 忘记资金密码
         * OTC_capital_code_wrong : 资金密码不正确，今日还可输入{0}次
         * OTC_capital_code_wrong_threeTime : 密码错误已3次，请明日再试
         * OTC_transfer_capital : 资金划转
         * OTC_capital_record : 资金记录
         * OTC_set_payment : 支付管理设置
         * OTC_otc_available_asset : 可用数量
         * OTC_otc_frozen_asset : 冻结数量
         * OTC_bankcard : 银行卡
         * OTC_alipay : 支付宝
         * OTC_bound : 已绑定
         * OTC_unbound : 未绑定
         * OTC_payment_management : 支付管理
         * OTC_set_bankcard_info : 银行卡设置
         * OTC_account_holder : 开户人
         * OTC_account_holder_null : 开户人为空
         * OTC_wrong_account_holder : 请输入正确的开户人姓名
         * OTC_deposit_bank : 开户银行
         * OTC_sub_branch : 开户支行
         * OTC_wrong_sub_branch : 请输入正确的开户支行
         * OTC_bankcard_num : 银行卡号
         * OTC_bankcard_num_null : 银行卡号为空
         * OTC_wrong_bankcard_num : 请输入正确的银行账号
         * OTC_bind : 绑定
         * OTC_cannot_modify : 您当前有发布中的广告，请等待广告完成或撤销后再尝试修改
         * OTC_transfer_operation : 划转操作
         * OTC_from : 从
         * OTC_transfer_to : 转至
         * OTC_otc_account : 法币交易账户
         * OTC_original_accout : 币币交易账户
         * OTC_all_in : 全部
         * OTC_transfer : 确定转入
         * OTC_set_alipay_info : 支付宝设置
         * OTC_alipay_real_name : 真实姓名
         * OTC_real_name_null : 真实姓名为空
         * OTC_wrong_real_name : 请输入正确的真实姓名
         * OTC_alipay_account : 支付宝账号
         * OTC_wrong_alipay_account : 请输入正确的支付宝账号
         * OTC_otc_to_original : 法币转币币
         * OTC_original_to_otc : 币币转法币
         * OTC_price_null : 价格为空
         * OTC_amount_null : 交易数量为空
         * OTC_limit_amount_over : 已超当日累计交易限额
         * OTC_min_limit_too_low : 最小交易限额不得低于100CNY
         * OTC_min_limit_too_high : 最小交易限额超过单笔交易限额
         * OTC_max_limit_too_low : 最大交易限额小于最小交易限额
         * OTC_max_limit_too_high : 最大交易限额超过单笔交易限额
         * OTC_payment_null : 请选择支付方式
         * OTC_account_not_enough : 账户余额不足
         * OTC_transfer_amount_null : 划转金额不得为空
         * OTC_convertible_amount_not_enough : 可转金额不足
         * OTC_name_incorrect : 请输入正确的姓名
         * OTC_IDno_incorrect : 请输入正确的证件号码
         * OTC_phone_incorrect : 请输入正确的手机号
         * OTC_fundpasscode_error : 资金密码错误，还有{0}次机会
         * OTC_fundpasscode_error_much : 密码输入错误3次，24小时后再尝试
         * OTC_input_incorrect : 输入不合法
         * OTC_alipay_incorrect : 请输入正确的支付宝账号
         * bank : [{"bank_name":"中国工商银行","id":"ICBC","pic":"1"},{"bank_name":"中国农业银行","id":"ABC","pic":"2"},{"bank_name":"中国银行","id":"BOC","pic":"3"},{"bank_name":"中国建设银行","id":"CCB","pic":"4"},{"bank_name":"交通银行","id":"BOCOM","pic":"5"},{"bank_name":"中国邮政储蓄银行","id":"PSBC","pic":"6"},{"bank_name":"招商银行","id":"CMB","pic":"7"},{"bank_name":"平安银行","id":"PAB","pic":"8"},{"bank_name":"广发银行","id":"CGB","pic":"9"},{"bank_name":"华夏银行","id":"HXB","pic":"10"},{"bank_name":"中国民生银行","id":"CMBC","pic":"11"},{"bank_name":"浦发银行","id":"SPDB","pic":"12"},{"bank_name":"渤海银行","id":"CBB","pic":"13"},{"bank_name":"中信银行","id":"CCITICB","pic":"14"},{"bank_name":"中国光大银行","id":"CEB","pic":"15"},{"bank_name":"上海银行","id":"BOS","pic":"16"},{"bank_name":"北京银行","id":"BOB","pic":"17"},{"bank_name":"兴业银行","id":"IB","pic":"18"},{"bank_name":"渤海银行","id":"CBB","pic":"19"}]
         */

        public String OTC_price;
        public String OTC_amount;
        public String OTC_buy_trade;
        public String OTC_sell_trade;
        public String OTC_coin_type;
        public String OTC_rise_fall;
        public String OTC_customer_name;
        public String OTC_OK;
        public String OTC_close;
        public String OTC_back;
        public String OTC_c2c_trade;
        public String OTC_c2c;
        public String OTC_order;
        public String OTC_account;
        public String OTC_buy_coin;
        public String OTC_sell_coin;
        public String OTC_release_deal;
        public String OTC_my_deal;
        public String OTC_cny_text;
        public String OTC_deal_times;
        public String OTC_limit_amount;
        public String OTC_repeat_order;
        public String OTC_repeat_order_reminder;
        public String OTC_no_deal_right;
        public String OTC_need_KYC_level;
        public String OTC_go_KYC;
        public String OTC_cancle;
        public String OTC_doing_deals;
        public String OTC_off_shelves;
        public String OTC_deal_detail;
        public String OTC_deal_number;
        public String OTC_need_bound_payway;
        public String OTC_deal_ditails;
        public String OTC_entrusted_sell;
        public String OTC_entrusted_amount;
        public String OTC_deal_amount;
        public String OTC_filled_amount;
        public String OTC_entrusted_time;
        public String OTC_total_price;
        public String OTC_completion_text;
        public String OTC_trade_violation;
        public String OTC_collect_way;
        public String OTC_submit_order;
        public String OTC_send_requesting;
        public String OTC_submit_success;
        public String OTC_deal_failure_redeal;
        public String OTC_recent_index;
        public String OTC_coin_type_select;
        public String OTC_frozen_amount;
        public String OTC_min_order_amount;
        public String OTC_max_order_amount;
        public String OTC_pay_way;
        public String OTC_repeat_deal;
        public String OTC_release_success;
        public String OTC_confirm_release;
        public String OTC_to_bound;
        public String OTC_need_more_KYC_level;
        public String OTC_KYC_certification_page;
        public String OTC_order_status;
        public String OTC_countdown;
        public String OTC_unfinished_order;
        public String OTC_history;
        public String OTC_create_order_time;
        public String OTC_not_paying;
        public String OTC_wait_for_release_coin;
        public String OTC_collection_need_confirm;
        public String OTC_deal_completion;
        public String OTC_deal_cancel;
        public String OTC_order_detail;
        public String OTC_order_num;
        public String OTC_copy;
        public String OTC_cancle_order;
        public String OTC_payment_completed;
        public String OTC_release_coin;
        public String OTC_contact_customer_service;
        public String OTC_real_name;
        public String OTC_pay_note_number;
        public String OTC_pay_reminder;
        public String OTC_confirm_cancel_order;
        public String OTC_cancel_order_reminder;
        public String OTC_cancel_confirm;
        public String OTC_question_meet;
        public String OTC_provide_resource;
        public String OTC_resource_one;
        public String OTC_resource_two;
        public String OTC_resource_three;
        public String OTC_resource_four;
        public String OTC_customer_need;
        public String OTC_sorry_for_question;
        public String OTC_thank_you;
        public String OTC_cancel_already;
        public String OTC_cancel_order_time;
        public String OTC_compelete_order_time;
        public String OTC_compelete_payment_time;
        public String OTC_input_capital_code;
        public String OTC_forget_capital_code;
        public String OTC_capital_code_wrong;
        public String OTC_capital_code_wrong_threeTime;
        public String OTC_transfer_capital;
        public String OTC_capital_record;
        public String OTC_set_payment;
        public String OTC_otc_available_asset;
        public String OTC_otc_frozen_asset;
        public String OTC_bankcard;
        public String OTC_alipay;
        public String OTC_bound;
        public String OTC_unbound;
        public String OTC_payment_management;
        public String OTC_set_bankcard_info;
        public String OTC_account_holder;
        public String OTC_account_holder_null;
        public String OTC_wrong_account_holder;
        public String OTC_deposit_bank;
        public String OTC_sub_branch;
        public String OTC_wrong_sub_branch;
        public String OTC_bankcard_num;
        public String OTC_bankcard_num_null;
        public String OTC_wrong_bankcard_num;
        public String OTC_bind;
        public String OTC_cannot_modify;
        public String OTC_transfer_operation;
        public String OTC_from;
        public String OTC_transfer_to;
        public String OTC_otc_account;
        public String OTC_original_accout;
        public String OTC_all_in;
        public String OTC_transfer;
        public String OTC_set_alipay_info;
        public String OTC_alipay_real_name;
        public String OTC_real_name_null;
        public String OTC_wrong_real_name;
        public String OTC_alipay_account;
        public String OTC_wrong_alipay_account;
        public String OTC_otc_to_original;
        public String OTC_original_to_otc;
        public String OTC_price_null;
        public String OTC_amount_null;
        public String OTC_limit_amount_over;
        public String OTC_min_limit_too_low;
        public String OTC_min_limit_too_high;
        public String OTC_max_limit_too_low;
        public String OTC_max_limit_too_high;
        public String OTC_payment_null;
        public String OTC_account_not_enough;
        public String OTC_transfer_amount_null;
        public String OTC_convertible_amount_not_enough;
        public String OTC_name_incorrect;
        public String OTC_IDno_incorrect;
        public String OTC_phone_incorrect;
        public String OTC_fundpasscode_error;
        public String OTC_fundpasscode_error_much;
        public String OTC_input_incorrect;
        public String OTC_alipay_incorrect;
        public List<BankBean> bank;

        public static class BankBean {
            /**
             * bank_name : 中国工商银行
             * id : ICBC
             * pic : 1
             */

            public String bank_name;
            public String id;
            public String pic;
        }
    }
}
