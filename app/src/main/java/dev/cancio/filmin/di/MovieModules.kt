package dev.cancio.filmin.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dev.cancio.filmin.presenter.DetailPresenter
import dev.cancio.filmin.presenter.HomePresenter
import dev.cancio.filmin.ui.activity.DetailActivity
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

@Subcomponent(modules = [DetailModule::class])
interface DetailSubComponent{
    fun inject(activity: DetailActivity)
}

@Module
class DetailModule(val activity: DetailActivity){

    @Provides
    fun provideView(): DetailPresenter.View = activity

    @Provides
    fun provideActivity() = activity

}