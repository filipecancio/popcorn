package dev.cancio.filmin.presenter

import android.content.Context
import android.util.Log
import dev.cancio.filmin.base.BasePresenter
import dev.cancio.filmin.base.BaseView
import dev.cancio.filmin.data.model.Movie
import dev.cancio.filmin.data.model.MoviePagination
import dev.cancio.filmin.data.repository.MovieRepository
import dev.cancio.filmin.data.service.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val view:View,
    private val movieRepository : MovieRepository
): BasePresenter<HomePresenter.View>(view) {


    fun getMoviesList(){
        onCallRepository()
    }

    fun onCallMock(){
        val mock = readJsonMock<MoviePagination>("mock_movie_pagination.json",MoviePagination::class.java)
        val results = mock.results
        view.inflateRecyclerView(results)
    }

    fun onCallRepository(){
        launch {
            movieRepository.getMoviesList().enqueue(object : Callback<MoviePagination> {
                override fun onResponse(
                    call: Call<MoviePagination>,
                    response: Response<MoviePagination>
                ) {
                    if(response.isSuccessful){
                        Log.i("TMDB", "Chamada deu certo!")
                        val moviePagination = response.body()
                        moviePagination?.apply {
                            view.inflateRecyclerView(results)
                        }
                    }else{
                        Log.i("TMDB", "Chamada deu errado!")
                        view.onError()
                    }
                }

                override fun onFailure(call: Call<MoviePagination>, t: Throwable) {
                    view.onError()
                }

            })
        }
    }

    interface View: BaseView{
        fun inflateRecyclerView(movieList: List<Movie>)
        fun onError()
    }
}