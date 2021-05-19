package com.itgonca.nbaapp.features.home.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.itgonca.nbaapp.databinding.ItemTeamLayoutBinding
import com.itgonca.nbaapp.features.home.domain.model.TeamItem
import com.itgonca.nbaapp.utils.extensions.loadImageUrl

class TeamsViewHolder(val binding:ItemTeamLayoutBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(itemTeam:TeamItem){
        binding.tvTeamName.text = itemTeam.shortName
        binding.ivTeamLogo.loadImageUrl(itemTeam.logo)
    }
}
