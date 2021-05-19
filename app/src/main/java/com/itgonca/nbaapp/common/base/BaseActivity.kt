package com.itgonca.nbaapp.common.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun showLoader()
    abstract fun hideLoader()
}