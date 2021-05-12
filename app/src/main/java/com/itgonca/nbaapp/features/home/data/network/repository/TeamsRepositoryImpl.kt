package com.itgonca.nbaapp.features.home.data.network.repository

import com.itgonca.nbaapp.common.data.network.RetrofitInstance
import com.itgonca.nbaapp.features.home.data.network.api.TeamsApi
import com.itgonca.nbaapp.features.home.data.network.model.TeamsResponse
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(val remoteTeams: TeamsApi) : TeamsRepository {
    override suspend fun getTeamsPerConference(conference: String): TeamsResponse =
        remoteTeams.getTeamsPerConference(
            "a6838d14abmsh7639ba8abedb803p1f3c94jsn86d70d44c12d",
            conference
        )
}