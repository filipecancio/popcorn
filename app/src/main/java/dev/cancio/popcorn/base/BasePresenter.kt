package dev.cancio.popcorn.base

import androidx.lifecycle.LifecycleObserver
import dev.cancio.popcorn.util.ResourceReader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.reflect.Type

abstract class BasePresenter<T : BaseView>(private val view: T) : LifecycleObserver {

    private val presenterJob = Job()
    private val uiScope
        get() = CoroutineScope(presenterJob + Dispatchers.Main)

    fun launch(callback: suspend CoroutineScope.() -> Unit): Job {
        return uiScope.launch { callback() }
    }

    fun <T> readJsonMock(fileName: String, type: Type) = ResourceReader.readJsonMock<T>(fileName,type)
}