package dev.cancio.filmin.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dev.cancio.filmin.data.repository.MovieRepository
import dev.cancio.filmin.presenter.MainPresenter
import dev.cancio.filmin.ui.activity.MainActivity

@Subcomponent(modules = [MainModule::class])
interface MainSubComponent{
    fun inject(activity: MainActivity)
}

@Module
class MovieModule() {

    @Provides
    fun provideMovie(): MovieRepository {
        return MovieRepository()
    }
}

@Module
class MainModule(val activity: MainActivity){
    @Provides
    fun provideMainView(): MainPresenter.View = activity
}

