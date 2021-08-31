package dev.cancio.filmin.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

abstract class BasePresenter<T: BaseView>(private val view: T): LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onStartView(){
        view.bindViews()
    }
}