package com.itgonca.nbaapp.features.home.data.network.repository

import com.itgonca.nbaapp.common.data.network.RetrofitInstance
import com.itgonca.nbaapp.features.home.data.network.model.TeamsResponse

class TeamsRepository() {
    suspend fun getTeamsPerConference(conference: String): TeamsResponse =
        RetrofitInstance.teamsApiService.getTeamsPerConference("a6838d14abmsh7639ba8abedb803p1f3c94jsn86d70d44c12d",conference)
}