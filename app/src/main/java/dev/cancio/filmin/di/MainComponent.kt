package dev.cancio.filmin.di

import dagger.Component
import dev.cancio.filmin.ui.activity.DetailActivity
import dev.cancio.filmin.ui.activity.HomeActivity

@Component(
    modules = [
        MainModule::class,
        RetrofitModule::class
    ]
)
interface MainComponent {
    fun plus(module: HomeModule): HomeSubComponent
    fun plus(module: DetailModule): DetailSubComponent

}