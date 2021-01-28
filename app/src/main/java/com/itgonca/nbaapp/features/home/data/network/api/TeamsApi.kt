package com.itgonca.nbaapp.features.home.data.network.api

import com.itgonca.nbaapp.features.home.data.network.model.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface TeamsApi {


    @GET("/teams/confName/{conference}")
    suspend fun getTeamsPerConference(
        @Header("x-rapidapi-key") apiKey:String,
        @Path("conference") conference: String
    ): TeamsResponse
}