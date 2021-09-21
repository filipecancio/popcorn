package dev.cancio.popcorn.di

import dagger.BindsInstance
import dagger.Component
import dagger.MembersInjector
import dev.cancio.popcorn.PopcornApplication
import javax.inject.Singleton

@Component(
    modules = [
        PopCornModule::class,
        RetrofitModule::class
    ]
)
@Singleton
interface ApplicationComponent: MembersInjector<PopcornApplication> {
    fun plus(module: HomeModule): HomeSubComponent
    fun plus(module: DetailModule): DetailSubComponent
    fun plus(module: LikeModule): LikeSubComponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun popCornApplication(app: PopcornApplication): Builder

        fun build(): ApplicationComponent
    }
}