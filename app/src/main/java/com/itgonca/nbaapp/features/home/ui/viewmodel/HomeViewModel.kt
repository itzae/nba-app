package com.itgonca.nbaapp.features.home.ui.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.nbaapp.features.home.data.network.repository.TeamsRepository
import com.itgonca.nbaapp.features.home.domain.model.TeamItem
import com.itgonca.nbaapp.features.home.domain.model.toTeamItem
import com.itgonca.nbaapp.utils.extensions.StateUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val teamsRepository: TeamsRepository) : ViewModel() {

    private val _listTeams = MutableLiveData<StateUI<List<TeamItem>>>()

    val listTeams: LiveData<StateUI<List<TeamItem>>>
        get() = _listTeams

    /**
     * This method obtains a list of equipment according to the selected conference, and later
     * processes the information to send it to the view through the observer [listTeams]
     */
    fun getTeams(conference:String) {
        viewModelScope.launch {
            try {
                _listTeams.postValue(StateUI.Loading)
                val data =
                    withContext(Dispatchers.IO) { teamsRepository.getTeamsPerConference(conference) }
                val listItems = data.api.teams.map { team -> team.toTeamItem() }
                _listTeams.postValue(StateUI.Success(listItems))
                Log.i("TAG", "getTeams: $data")
            } catch (e: Exception) {
                Log.e("TAG", "getTeams: ${e.message}")
            }
        }
    }
}