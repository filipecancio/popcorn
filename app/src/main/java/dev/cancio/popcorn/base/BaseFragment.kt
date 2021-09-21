package dev.cancio.popcorn.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun getApplication() = (activity as BaseActivity).getPopcornApplication()

    fun getApplicationComponent() = getApplication().applicationComponent
}