package com.sinaseyfi.kiliaroalbum.data.base.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.sinaseyfi.kiliaroalbum.data.base.sharedpreferences.Preferences.Companion.PREFERENCES_NAME

abstract class BaseSharedPreferences(context: Context) :
    Preferences {

    protected val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

}