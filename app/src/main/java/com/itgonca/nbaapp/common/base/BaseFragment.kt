package com.itgonca.nbaapp.common.base

import androidx.fragment.app.Fragment
import com.itgonca.nbaapp.features.app.MainActivity

abstract class BaseFragment:Fragment() {
    fun getActivityContext() = (activity as MainActivity)
}