@file:Suppress("PropertyName")

package com.sinaseyfi.kiliaroalbum.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


abstract class BaseViewModel<V : ViewState>(
    initViewState: V
) : ViewModel()
{
    
    private val _viewState = MutableStateFlow(initViewState)
    val viewState: StateFlow<V> = _viewState

    protected fun setViewState(value: V) {
        _viewState.value = value
    }

}