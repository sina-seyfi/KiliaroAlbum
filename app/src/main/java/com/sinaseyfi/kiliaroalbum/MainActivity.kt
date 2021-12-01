package com.sinaseyfi.kiliaroalbum

import android.view.LayoutInflater
import com.sinaseyfi.kiliaroalbum.ui.base.BaseActivity
import com.sinaseyfi.kiliaroalbum.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main
    override val navHostFragmentId: Int = R.id.mainNavHostFragment

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

}