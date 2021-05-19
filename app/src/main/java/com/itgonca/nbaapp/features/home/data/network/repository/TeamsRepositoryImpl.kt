package com.itgonca.nbaapp.features.home.data.network.repository

import com.itgonca.nbaapp.BuildConfig
import com.itgonca.nbaapp.features.home.data.network.api.TeamsApi
import com.itgonca.nbaapp.features.home.data.network.model.TeamsResponse
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(val remoteTeams: TeamsApi) : TeamsRepository {
    override suspend fun getTeamsPerConference(conference: String): TeamsResponse =
        remoteTeams.getTeamsPerConference(
            BuildConfig.API_KEY,
            conference
        )
}