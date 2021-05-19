package com.itgonca.nbaapp.features.home.domain.model

import android.os.Parcelable
import com.itgonca.nbaapp.features.home.data.network.model.Team
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamItem(val teamId: String, val shortName: String, val logo: String) : Parcelable

fun Team.toTeamItem() = TeamItem(this.teamId, this.shortName, this.logo)