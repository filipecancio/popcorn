package dev.cancio.filmin.presenter

import android.content.Context
import android.widget.Toast
import dev.cancio.filmin.base.BasePresenter
import dev.cancio.filmin.base.BaseView
import dev.cancio.filmin.data.model.Movie
import dev.cancio.filmin.data.model.MoviePagination
import dev.cancio.filmin.data.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter(private val view:View): BasePresenter<MainPresenter.View>(view) {

    @Inject
    lateinit var movieRepository: MovieRepository

    fun getMoviesList(context: Context){
        onCallMock()
    }

    private fun onError(context: Context) {
        Toast.makeText(context, "A conexão falhou", Toast.LENGTH_SHORT).show()
    }
    fun onCallMock(){
        val mock = readJsonMock<MoviePagination>("mock_movie_pagination.json",MoviePagination::class.java)
        val results = mock.results
        view.inflateRecyclerView(results)
    }

    fun onCallRepository(context: Context){
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
                        onError(context)
                    }
                }

                override fun onFailure(call: Call<MoviePagination>, t: Throwable) {
                    onError(context)
                }

            })
        }
    }

    interface View: BaseView{
        fun inflateRecyclerView(movieList: List<Movie>)
    }
}