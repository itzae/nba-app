package com.itgonca.nbaapp.features.home.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.itgonca.nbaapp.common.base.BaseFragment
import com.itgonca.nbaapp.databinding.FragmentHomeBinding
import com.itgonca.nbaapp.features.home.data.network.repository.TeamsRepository
import com.itgonca.nbaapp.features.home.ui.adapters.TeamsAdapter
import com.itgonca.nbaapp.features.home.ui.viewmodel.HomeViewModel
import com.itgonca.nbaapp.utils.extensions.StateUI
import com.itgonca.nbaapp.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var teamsAdapter: TeamsAdapter

    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by lazy {
        getViewModel { (HomeViewModel(TeamsRepository())) }
    }

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
        viewModel.getTeams()
        initObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /**
     * This method initialize the observers of the [HomeViewModel]
     */
    private fun initObservers() {
        viewModel.listTeams.observe(viewLifecycleOwner, Observer {
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