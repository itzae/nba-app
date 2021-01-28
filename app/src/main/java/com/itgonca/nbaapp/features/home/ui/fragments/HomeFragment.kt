package com.itgonca.nbaapp.features.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.itgonca.nbaapp.databinding.FragmentHomeBinding
import com.itgonca.nbaapp.features.home.data.network.repository.TeamsRepository
import com.itgonca.nbaapp.features.home.ui.viewmodel.HomeViewModel
import com.itgonca.nbaapp.utils.extensions.getViewModel

class HomeFragment : Fragment() {

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
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}