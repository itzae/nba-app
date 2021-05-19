package com.itgonca.nbaapp.features.home.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.itgonca.nbaapp.common.base.BaseFragment
import com.itgonca.nbaapp.databinding.FragmentHomeBinding
import com.itgonca.nbaapp.features.home.ui.adapters.TeamsAdapter
import com.itgonca.nbaapp.features.home.ui.viewmodel.HomeViewModel
import com.itgonca.nbaapp.utils.extensions.StateUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var teamsAdapter: TeamsAdapter

    private val binding get() = _binding!!

    private val viewModel :HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        teamsAdapter = TeamsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTeams("East")
        initUI()
        initObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initUI(){
        binding.chgConference.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                binding.chEast.id -> viewModel.getTeams("East")
                binding.chWest.id -> viewModel.getTeams("West")
            }
        }
    }

    /**
     * This method initialize the observers of the [HomeViewModel]
     */
    private fun initObservers() {
       viewModel.listTeams.observe(viewLifecycleOwner, {
            when (it) {
                is StateUI.Success -> {
                    getActivityContext().hideLoader()
                    teamsAdapter.submitList(it.data)
                    binding.rvTeams.adapter = teamsAdapter
                    Log.i("TAG", "initObservers: ${it.data}")
                }
                is StateUI.Error -> {
                    Log.e("TAG", "initObservers: ${it.message}")
                }
                StateUI.Loading -> getActivityContext().showLoader()
            }
        })
    }

}