package dev.cancio.popcorn.presenter


import dev.cancio.filmin.data.repository.MovieRepository
import dev.cancio.popcorn.base.BasePresenter
import dev.cancio.popcorn.base.BaseView
import dev.cancio.popcorn.data.model.dataclass.MovieResponse
import javax.inject.Inject
import kotlin.random.Random

class HomePresenter @Inject constructor(
    private val view: View,
    private val movieRepository: MovieRepository
) : BasePresenter<HomePresenter.View>(view) {

    fun getMoviesList() {
        launch {
            val response = movieRepository.getMoviesList()
            if (response.isSuccessful) {
                val moviePagination = response.body()
                moviePagination?.apply {
                    view.inflateRecyclerView(results)
                    getRandomRelease(results)
                }
            } else {
                view.onError()
            }
        }
    }

    private fun getRandomRelease(results: List<MovieResponse>) {
        val randomIndex = Random.nextInt(results.size)
        view.inflateDiscoverPoster(results[randomIndex])
    }

    interface View : BaseView {
        fun inflateRecyclerView(movieResponseList: List<MovieResponse>)
        fun inflateDiscoverPoster(movieResponse: MovieResponse)
        fun onError()
    }
}