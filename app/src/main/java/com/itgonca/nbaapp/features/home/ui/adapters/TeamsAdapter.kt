package com.itgonca.nbaapp.features.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.itgonca.nbaapp.databinding.ItemTeamLayoutBinding
import com.itgonca.nbaapp.features.home.domain.model.TeamItem

class TeamsAdapter : ListAdapter<TeamItem, TeamsViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val view = ItemTeamLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(team)
    }
}

private class DiffUtilCallback : DiffUtil.ItemCallback<TeamItem>() {
    override fun areItemsTheSame(oldItem: TeamItem, newItem: TeamItem): Boolean =
        oldItem.teamId == newItem.teamId


    override fun areContentsTheSame(oldItem: TeamItem, newItem: TeamItem): Boolean =
        oldItem == newItem
}