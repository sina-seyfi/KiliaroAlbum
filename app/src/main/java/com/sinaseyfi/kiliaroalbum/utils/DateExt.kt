package com.sinaseyfi.kiliaroalbum.utils

import android.text.format.DateUtils
import net.time4j.*


fun DateUtils.nowTimestamp(): Long {
    return TemporalType.MILLIS_SINCE_UNIX.from(PlainTimestamp.nowInSystemTime().atUTC())
}