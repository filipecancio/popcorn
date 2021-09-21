package dev.cancio.popcorn.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dev.cancio.popcorn.presenter.DetailPresenter
import dev.cancio.popcorn.presenter.HomePresenter
import dev.cancio.popcorn.presenter.LikePresenter
import dev.cancio.popcorn.ui.fragment.DetailFragment
import dev.cancio.popcorn.ui.fragment.HomeFragment
import dev.cancio.popcorn.ui.fragment.LikeFragment

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

@Subcomponent(modules = [DetailModule::class])
interface DetailSubComponent{
    fun inject(fragment: DetailFragment)
}

@Module
class DetailModule(val fragment: DetailFragment){

    @Provides
    fun provideView(): DetailPresenter.View = fragment

    @Provides
    fun provideActivity() = fragment
}

@Subcomponent(modules = [LikeModule::class])
interface LikeSubComponent{
    fun inject(fragment: LikeFragment)
}

@Module
class LikeModule(val fragment: LikeFragment){

    @Provides
    fun provideView(): LikePresenter.View = fragment

    @Provides
    fun provideActivity() = fragment
}