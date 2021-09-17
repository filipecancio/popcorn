package dev.cancio.popcorn.presenter

import dev.cancio.filmin.data.repository.MovieRepository
import dev.cancio.popcorn.base.BasePresenter
import dev.cancio.popcorn.base.BaseView
import dev.cancio.popcorn.data.model.dataclass.Credit
import dev.cancio.popcorn.data.model.dataclass.MovieDetail
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val view: View,
    private val movieRepository : MovieRepository
) : BasePresenter<DetailPresenter.View>(view) {


    fun getCredit(movieId: Int){
        launch {
            val response = movieRepository.getMovieCredits(movieId)
            if(response.isSuccessful){
                val credit = response.body()
                credit?.apply {
                    view.inflateRecyclerView(this)
                }
            }else{
                view.onError()
            }
        }
    }
    fun getMovieDetail(movieId: Int){
        launch {
            val response = movieRepository.getMovieDetail(movieId)
            if(response.isSuccessful){
                val detail = response.body()
                detail?.apply {
                    view.bindDetails(this)
                }
            }else{
                view.onError()
            }
        }
    }

    interface View : BaseView {
        fun bindDetails(details: MovieDetail)
        fun inflateRecyclerView(credit: Credit)
        fun onError()
    }
}