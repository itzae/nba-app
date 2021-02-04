package com.itgonca.nbaapp.features.home.domain.model

import com.itgonca.nbaapp.features.home.data.network.model.Team

data class TeamItem(val teamId: String, val shortName: String, val logo: String)

fun Team.toTeamItem() = TeamItem(this.teamId, this.shortName, this.logo)