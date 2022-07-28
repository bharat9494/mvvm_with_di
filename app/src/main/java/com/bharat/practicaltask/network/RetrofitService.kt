package com.bharat.practicaltask.network

import com.bharat.practicaltask.data.models.CoinResponse
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface RetrofitService {
    @GET("coinlist")
    suspend fun getCoinList(): Response<CoinResponse>
}

//object RetrofitApi {
//    private val okHttp = OkHttpClient.Builder()
//    private val builder = Retrofit.Builder().baseUrl(baseUrl)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(okHttp.build())
//
//    private val retrofit = builder.build()
//
//    fun <T> buildService(serviceType: Class<T>): T {
//        return retrofit.create(serviceType)
//    }
//}