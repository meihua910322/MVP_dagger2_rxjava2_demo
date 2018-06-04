package org.dae.exchange.common.api

import cn.meihua.mvp_dagger2_rxjava2_demo.api.HttpApiService
import io.reactivex.Observable

/**
 *
 * @author muaj
 * @date 2017/12/7
 */
object ApiRepository {
    private var mApiService: HttpApiService = RetrofitClient.createService(HttpApiService::class.java)




}