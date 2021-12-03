package com.sinaseyfi.kiliaroalbum.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), text, duration).show()
}