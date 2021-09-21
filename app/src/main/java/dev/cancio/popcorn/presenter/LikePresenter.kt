package dev.cancio.popcorn.presenter

import dev.cancio.popcorn.base.BasePresenter
import dev.cancio.popcorn.base.BaseView
import dev.cancio.popcorn.data.model.entity.Movie
import dev.cancio.popcorn.data.repository.LikeMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class LikePresenter @Inject constructor(
    private val view: View,
    private  val likeMovieRepository: LikeMovieRepository
): BasePresenter<LikePresenter.View>(view) {

    fun getLikedMovies(){
        launch {
            val movieList = likeMovieRepository
                .getLikedMovies()
                .flattenToList()
            view.inflateRecyclerView(movieList)
        }
    }

    private suspend fun <T> Flow<List<T>>.flattenToList() =
        flatMapConcat { it.asFlow() }.toList()


    interface View : BaseView {
        fun inflateRecyclerView(movieResponseList: List<Movie>)
    }
}