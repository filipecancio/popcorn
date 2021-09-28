package dev.cancio.popcorn.presenter

import dev.cancio.filmin.data.repository.MovieRepository
import dev.cancio.popcorn.base.BasePresenter
import dev.cancio.popcorn.base.BaseView
import dev.cancio.popcorn.data.model.dataclass.Credit
import dev.cancio.popcorn.data.model.dataclass.MovieDetail
import dev.cancio.popcorn.data.repository.LikeMovieRepository
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val view: View,
    private val movieRepository: MovieRepository,
    private val likeMovieRepository: LikeMovieRepository
) : BasePresenter<DetailPresenter.View>(view) {

    private lateinit var movieDetail: MovieDetail
    private lateinit var credit: Credit
    private var isLiked: Boolean = false


    fun getCredit(movieId: Int) {
        launch {
            val response = movieRepository.getMovieCredits(movieId)
            if (response.isSuccessful) {
                val creditResponse = response.body()
                creditResponse?.apply {
                    credit = this
                    view.inflateRecyclerView(this)
                }
            } else {
                view.onError()
            }
        }
    }

    fun getMovieDetail(movieId: Int) {
        launch {
            val response = movieRepository.getMovieDetail(movieId)
            if (response.isSuccessful) {
                val detailResponse = response.body()
                detailResponse?.apply {
                    movieDetail = this
                    view.bindDetails(this)
                }
            } else {
                view.onError()
            }
        }
    }

    fun getLikedState(movieId: Int) {
        launch {
            isLiked = likeMovieRepository.getMovie(movieId) != null
            view.setIsLikedFab(isLiked)
        }
    }

    fun setLikeOnMovie() {
        if (isLiked) {
            unlikeMovie()
        } else {
            likeMovie()
        }
        isLiked = !isLiked
        view.setIsLikedFab(isLiked)
    }

    private fun likeMovie() {
        launch {
            val movie = movieDetail.toEntity()
            likeMovieRepository.likeMovie(movie)
        }
    }

    private fun unlikeMovie() {
        launch {
            val movieId = movieDetail.id
            likeMovieRepository.unlikeMovie(movieId)
        }
    }

    interface View : BaseView {
        fun bindDetails(details: MovieDetail)
        fun inflateRecyclerView(credit: Credit)
        fun setIsLikedFab(isLiked: Boolean)
        fun onError()
    }
}