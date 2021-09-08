package dev.cancio.filmin.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dev.cancio.filmin.presenter.HomePresenter
import dev.cancio.filmin.ui.activity.HomeActivity

@Subcomponent(modules = [HomeModule::class])
interface HomeSubComponent{
    fun inject(activity: HomeActivity)
}

@Module
class HomeModule(val activity: HomeActivity){

    @Provides
    fun provideView(): HomePresenter.View = activity

    @Provides
    fun provideActivity() = activity
}