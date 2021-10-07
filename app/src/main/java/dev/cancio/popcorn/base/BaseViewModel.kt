package dev.cancio.popcorn.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    private val viewModelJob = Job()
    private val uiScope
        get() = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun launch(callback: suspend CoroutineScope.() -> Unit): Job {
        return uiScope.launch { callback() }
    }
}