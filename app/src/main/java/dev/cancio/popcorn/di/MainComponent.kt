package dev.cancio.popcorn.di

import dagger.Component

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