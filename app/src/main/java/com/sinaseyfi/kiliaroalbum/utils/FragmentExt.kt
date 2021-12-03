package com.sinaseyfi.presentation.ui.utils

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.sinaseyfi.kiliaroalbum.R

fun Fragment.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), text, duration).show()
}

fun Fragment.showSnackbar(@StringRes messageId: Int) {
    this.view?.let { Snackbar.make(it, messageId, Snackbar.LENGTH_SHORT).show() }
}

fun Fragment.showSnackbar(message: String) {
    this.view?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() }
}

fun Fragment.hideKeyboard() {
    val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
    var view = view
    if (view == null) {
        view = View(context)
    }
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.showKeyboard() {
    val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
    var view = view
    if (view == null) {
        view = View(context)
    }
    imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Fragment.finish() {
    activity?.run { finish() }
}

fun Fragment.runOnUiThread(runnable: () -> Unit = {}) {
    activity?.runOnUiThread { runnable.invoke() }
}

fun Fragment.createGeneralSnackBar(message: String, duration: Int = Snackbar.LENGTH_SHORT, actionName: String? = null, actionCallback: (Snackbar) -> Unit = {}): Snackbar? =
    if(context != null && view != null) {
        Snackbar.make(requireContext(), requireView(), message, duration).apply {
            actionName?.let { name -> setAction(name) { actionCallback.invoke(this) } }
        }
    } else null

fun Fragment.showGeneralSnackBar(message: String, duration: Int = Snackbar.LENGTH_SHORT, actionName: String? = null, actionCallback: (Snackbar) -> Unit = {}) {
    createGeneralSnackBar(message, duration, actionName, actionCallback)?.show()
}