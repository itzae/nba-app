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
import com.itgonca.nbaapp.features.home.ui.viewmodel.HomeViewModel
import com.itgonca.nbaapp.utils.extensions.StateUI
import com.itgonca.nbaapp.utils.extensions.getViewModel

class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by lazy {
        getViewModel { (HomeViewModel(TeamsRepository())) }
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

    private fun initObservers() {
        viewModel.listTeams.observe(viewLifecycleOwner, Observer {
            when (it) {
                is StateUI.Success -> {
                    getActivityContext().hideLoader()
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