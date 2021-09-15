package dev.cancio.popcorn.base

import androidx.viewbinding.ViewBinding

interface BaseView{
    val binding: ViewBinding

    fun bindViews()
}