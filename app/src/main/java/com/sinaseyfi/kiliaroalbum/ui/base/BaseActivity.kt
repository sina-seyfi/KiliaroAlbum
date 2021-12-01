package com.sinaseyfi.kiliaroalbum.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    companion object {

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    @get:LayoutRes
    protected abstract val layoutId: Int

    @get:IdRes
    protected abstract val navHostFragmentId: Int
    protected lateinit var navController: NavController
    protected lateinit var viewBinding: B

    abstract fun createViewBinding(layoutInflater: LayoutInflater): B

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = createViewBinding(layoutInflater)
        setContentView(viewBinding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(navHostFragmentId) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp() = navController.navigateUp() || super.onSupportNavigateUp()

}