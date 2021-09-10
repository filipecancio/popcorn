package dev.cancio.filmin.base

import androidx.viewbinding.ViewBinding

interface BaseView{
    val binding: ViewBinding

    fun bindViews()
}