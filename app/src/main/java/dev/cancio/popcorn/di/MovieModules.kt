package dev.cancio.popcorn.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dev.cancio.popcorn.presenter.HomePresenter
import dev.cancio.popcorn.ui.activity.HomeActivity
import dev.cancio.popcorn.ui.fragment.HomeFragment

@Subcomponent(modules = [HomeModule::class])
interface HomeSubComponent{
    fun inject(fragment: HomeFragment)
}

@Module
class HomeModule(val fragment: HomeFragment){

    @Provides
    fun provideView(): HomePresenter.View = fragment

    @Provides
    fun provideActivity() = fragment
}