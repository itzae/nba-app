package com.itgonca.nbaapp.features.home.data.network.repository

import com.itgonca.nbaapp.features.home.data.network.model.TeamsResponse

interface TeamsRepository {
    suspend fun getTeamsPerConference(conference:String) : TeamsResponse
}