package com.bharat.practicaltask.network

import com.bharat.practicaltask.data.models.CoinResponse
import retrofit2.Response
import javax.inject.Inject

class AppRepo @Inject constructor(internal val retrofitService: RetrofitService){

    suspend fun getCoinList(): Response<CoinResponse> {
        return retrofitService.getCoinList()
    }

}