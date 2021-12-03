package com.sinaseyfi.kiliaroalbum.utils

import net.time4j.PlainTimestamp
import net.time4j.TemporalType


fun nowTimestamp(): Long {
    return TemporalType.MILLIS_SINCE_UNIX.from(PlainTimestamp.nowInSystemTime().atUTC())
}