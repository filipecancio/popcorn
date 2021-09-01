package dev.cancio.filmin.di

import dagger.Component
import dev.cancio.filmin.ui.activity.MainActivity

@Component(
    modules = [MovieModule::class]
)
interface MovieComponent {
    fun plus(module: MainModule):MainSubComponent

    fun inject(activity: MainActivity)
}