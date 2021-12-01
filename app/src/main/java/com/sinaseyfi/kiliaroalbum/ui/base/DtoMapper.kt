package com.sinaseyfi.kiliaroalbum.ui.base

interface DtoMapper<D, DM> {

    fun mapToData(dto: D): DM

}