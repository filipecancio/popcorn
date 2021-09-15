package dev.cancio.popcorn.presenter

import dev.cancio.popcorn.base.BasePresenter
import dev.cancio.popcorn.base.BaseView
import dev.cancio.popcorn.data.model.Movie
import dev.cancio.popcorn.data.model.MoviePagination
import dev.cancio.popcorn.data.repository.MovieRepository
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val view:View,
    private val movieRepository : MovieRepository
): BasePresenter<HomePresenter.View>(view) {

    fun getMoviesList(){
        launch {
            val response = movieRepository.getMoviesList()
            if(response.isSuccessful){
                val moviePagination = response.body()
                moviePagination?.apply {
                    view.inflateRecyclerView(results)
                }
            }else{
                view.onError()
                onCallMock()
            }
        }
    }

    private fun onCallMock(){
        val fileName = "mock_movie_pagination.json"
        val mock = readJsonMock<MoviePagination>(fileName,MoviePagination::class.java)
        val results = mock.results
        view.inflateRecyclerView(results)
    }

    interface View: BaseView{
        fun inflateRecyclerView(movieList: List<Movie>)
        fun onError()
    }
}