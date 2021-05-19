package com.itgonca.nbaapp.common.data.network

import com.itgonca.nbaapp.BuildConfig
import com.itgonca.nbaapp.features.home.data.network.api.TeamsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val httpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val teamsApiService: TeamsApi = retrofit.create(TeamsApi::class.java)
}