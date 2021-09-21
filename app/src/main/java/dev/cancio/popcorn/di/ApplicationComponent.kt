package dev.cancio.popcorn.di

import dagger.BindsInstance
import dagger.Component
import dagger.MembersInjector
import dev.cancio.popcorn.PopCornApplication

@Component(
    modules = [
        PopCornModule::class,
        RetrofitModule::class
    ]
)
interface ApplicationComponent: MembersInjector<PopCornApplication> {
    fun plus(module: HomeModule): HomeSubComponent
    fun plus(module: DetailModule): DetailSubComponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun popCornApplication(app: PopCornApplication): Builder

        fun build(): ApplicationComponent
    }
}