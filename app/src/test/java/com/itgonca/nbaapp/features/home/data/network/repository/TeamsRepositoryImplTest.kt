package com.itgonca.nbaapp.features.home.data.network.repository

import com.itgonca.nbaapp.features.home.data.network.api.TeamsApi
import com.itgonca.nbaapp.features.home.data.network.model.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class TeamsRepositoryImplTest {

    //Test subject
    lateinit var teamsRepository: TeamsRepository

    //Collaborators
    lateinit var teamsApi: TeamsApi

    //Utilities
    lateinit var teamsForApi: TeamsResponse

    @Before
    fun setUp() {
        teamsApi = mock()
        teamsForApi = TeamsResponse(
            Api(
                0,
                "Ok",
                1,
                arrayListOf(),
                listOf(
                    Team(
                        "Atlanta",
                        "Atlanta Hawks",
                        "1",
                        "Hawks",
                        "https://upload.wikimedia.org/wikipedia/fr/e/ee/Hawks_2016.png",
                        "ATL",
                        "0",
                        "1",
                        Leagues(LeageInfo("East", "Southeast"))
                    )
                )
            )
        )
        runBlocking {
            whenever(teamsApi.getTeamsPerConference(any(), any())).thenReturn(teamsForApi)
        }
        teamsRepository = TeamsRepositoryImpl(teamsApi)

    }

    @Test
    fun getTeamsPerConference() {
        runBlocking {
            val team = teamsRepository.getTeamsPerConference("east")
            assertEquals(team, teamsForApi)
            assertEquals(team.api.teams[0].nickname,"Hawks")
        }
    }
}