package com.itgonca.nbaapp.features.home.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.nbaapp.features.home.data.network.repository.TeamsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val teamsRepository: TeamsRepository) : ViewModel() {

    fun getTeams() {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO) { teamsRepository.getTeamsPerConference("West") }
                Log.i("TAG", "getTeams: $data")
            }catch (e:Exception){
                Log.e("TAG", "getTeams: ${e.message}" )
            }
        }
    }
}