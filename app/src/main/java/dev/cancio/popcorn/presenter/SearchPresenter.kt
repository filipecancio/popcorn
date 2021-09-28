package dev.cancio.popcorn.presenter

import dev.cancio.filmin.data.repository.MovieRepository
import dev.cancio.popcorn.base.BasePresenter
import dev.cancio.popcorn.base.BaseView
import dev.cancio.popcorn.data.model.dataclass.MovieResponse
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val view: View,
    private val movieRepository: MovieRepository
): BasePresenter<SearchPresenter.View>(view) {

    fun getMoviesList(movieName: String? = null){
        launch {
            val response = if(movieName == null){
                movieRepository.getMoviesList()
            }else{
                movieRepository.getMovieSearch(movieName)
            }
            if (response.isSuccessful) {
                val moviePagination = response.body()
                moviePagination?.apply {
                    view.inflateRecyclerView(results)
                }
            } else {
                view.onError()
            }
        }
    }

    interface View: BaseView {
        fun inflateRecyclerView(movieResponseList: List<MovieResponse>)
        fun onError()
    }
}