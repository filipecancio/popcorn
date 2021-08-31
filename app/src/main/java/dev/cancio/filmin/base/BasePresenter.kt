package dev.cancio.filmin.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BasePresenter<T: BaseView>(private val view: T): LifecycleObserver{

    private val presenterJob = Job()
    private val uiScope
        get() = CoroutineScope(presenterJob + Dispatchers.Main)

    fun launch(callback: suspend CoroutineScope.() -> Unit): Job {
        return uiScope.launch { callback() }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onStartView(){
        view.bindViews()
    }
}