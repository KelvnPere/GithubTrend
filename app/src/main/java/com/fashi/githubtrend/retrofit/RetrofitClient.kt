package com.fashi.githubtrend.retrofit

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.lang.annotation.ElementType

class RetrofitClient {

    private val BASE_URL = "https://api.github.com/"

    //Get Retrofit Instance
    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Get API Service and return API Service
    fun getApiService(): Api {
        return getRetrofitInstance().create(Api::class.java)
    }

//    fun <T> getApiService(serviceType: Class<T>): Api {
//        return getRetrofitInstance().create(Api::class.java)
//    }
//

}