package dev.cancio.filmin.presenter

import android.content.Context
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

class HomePresenter @Inject constructor(private val view:View): BasePresenter<HomePresenter.View>(view) {

    @Inject
    lateinit var movieRepository: MovieService

    fun getMoviesList(context: Context){
        onCallMock()
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
                        val moviePagination = response.body()
                        moviePagination?.apply {
                            view.inflateRecyclerView(results)
                        }
                    }else{
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