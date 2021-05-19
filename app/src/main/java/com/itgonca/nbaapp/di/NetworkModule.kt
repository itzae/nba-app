package com.itgonca.nbaapp.di

import com.google.gson.GsonBuilder
import com.itgonca.nbaapp.BuildConfig
import com.itgonca.nbaapp.features.home.data.network.api.TeamsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providerBuildRetrofit(httpClient: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(httpClient.build())
            .build()
    }

    @Singleton
    @Provides
    fun providerHttpClient() = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
    })

    @Singleton
    @Provides
    fun providerTeamsService(builder:Retrofit):TeamsApi = builder.create(TeamsApi::class.java)

}