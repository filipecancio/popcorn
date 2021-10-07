package dev.cancio.popcorn.viewmodel

import androidx.lifecycle.MutableLiveData
import dev.cancio.filmin.data.repository.MovieRepository
import dev.cancio.popcorn.base.BaseViewModel
import dev.cancio.popcorn.data.model.dataclass.MovieResponse
import javax.inject.Inject
import kotlin.random.Random

class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    val movieList = MutableLiveData<List<MovieResponse>>()
    val tredingMovie = MutableLiveData<MovieResponse>()
    val errorMessage = MutableLiveData<String>()

    fun getMoviesList() {
        launch {
            val response = movieRepository.getMoviesList()
            if (response.isSuccessful) {
                val moviePagination = response.body()
                moviePagination?.apply {
                    movieList.postValue(results)
                    getRandomRelease(results)
                }
            } else {
                errorMessage.postValue(response.message())
            }
        }
    }

    private fun getRandomRelease(results: List<MovieResponse>) {
        val randomIndex = Random.nextInt(results.size)
        tredingMovie.postValue(results[randomIndex])
    }
}