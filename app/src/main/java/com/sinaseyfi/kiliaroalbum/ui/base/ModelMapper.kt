package com.sinaseyfi.kiliaroalbum.ui.base

import com.sinaseyfi.kiliaroalbum.data.base.Model

interface ModelMapper<M: Model, UIM: UIModel> {
    fun mapToUIModel(model: M): UIM
}