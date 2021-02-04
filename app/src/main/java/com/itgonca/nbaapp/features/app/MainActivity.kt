package com.itgonca.nbaapp.features.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itgonca.nbaapp.R
import com.itgonca.nbaapp.common.base.BaseActivity
import com.itgonca.nbaapp.common.presentation.ui.dialogs.LoaderDialog

class MainActivity : BaseActivity() {

    private var dialogLoader: LoaderDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialogLoader = LoaderDialog.newInstance()
    }

    override fun showLoader() {
        dialogLoader?.show(supportFragmentManager, LoaderDialog.TAG)
    }

    override fun hideLoader() {
        dialogLoader?.dismiss()
    }

}