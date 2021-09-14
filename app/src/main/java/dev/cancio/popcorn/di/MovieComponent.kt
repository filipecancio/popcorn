package dev.cancio.popcorn.di

import dagger.Component
import dev.cancio.popcorn.ui.activity.MainActivity

@Component(
    modules = [MovieModule::class]
)
interface MovieComponent {
    fun inject(activity: MainActivity)
}