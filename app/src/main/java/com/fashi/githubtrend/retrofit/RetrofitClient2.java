package com.fashi.githubtrend.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient2 {

    private static final  String BASE_URL = "https://api.github.com/";

    private  static Retrofit getRetrofitInstance(){
        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Api getApiService2(){
        return getRetrofitInstance().create(Api.class);
    }

}
