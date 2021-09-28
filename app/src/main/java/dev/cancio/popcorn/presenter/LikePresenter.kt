package dev.cancio.popcorn.presenter

import dev.cancio.popcorn.base.BasePresenter
import dev.cancio.popcorn.base.BaseView
import dev.cancio.popcorn.data.model.entity.Movie
import dev.cancio.popcorn.data.repository.LikeMovieRepository
import javax.inject.Inject

class LikePresenter @Inject constructor(
    private val view: View,
    private val likeMovieRepository: LikeMovieRepository
) : BasePresenter<LikePresenter.View>(view) {

    fun getLikedMovies() {
        launch {
            val movieList = likeMovieRepository
                .getLikedMovies()
            view.inflateRecyclerView(movieList)
        }

    }

    interface View : BaseView {
        fun inflateRecyclerView(movieResponseList: List<Movie>)
    }
}