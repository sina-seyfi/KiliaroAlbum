package com.sinaseyfi.kiliaroalbum.data.base.database

import com.sinaseyfi.kiliaroalbum.data.base.Model
import com.sinaseyfi.kiliaroalbum.data.base.Table

interface TableMapper<T: Table, M: Model> {

    fun mapToModel(table: T): M
    fun mapToTable(model: M): T

}