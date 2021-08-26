package dev.cancio.filmin.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.filmin.BuildConfig
import dev.cancio.filmin.data.api.MovieApi
import dev.cancio.filmin.data.model.MoviePagination
import dev.cancio.filmin.databinding.ActivityMainBinding
import dev.cancio.filmin.ui.adapter.MovieItemAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val API_KEY = BuildConfig.API_TOKEN
    private  val movieApi by lazy { MovieApi() }

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieItemAdapter: MovieItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMoviesList(API_KEY,binding,this)
    }

    private fun getMoviesList(api_key: String,binding: ActivityMainBinding,context:Context){
        movieApi.getMoviesList(api_key).enqueue(object : Callback<MoviePagination>{
            override fun onResponse(
                call: Call<MoviePagination>,
                response: Response<MoviePagination>
            ) {
                if(response.isSuccessful){
                    val moviePagination = response.body()
                    moviePagination?.apply {
                        movieItemAdapter = MovieItemAdapter(context, results)
                        recyclerView = binding.mainRecyclerview
                        val manager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

                        recyclerView.apply {
                            layoutManager = manager
                            adapter = movieItemAdapter
                        }
                    }
                }else{
                    onError()
                }
            }

            override fun onFailure(call: Call<MoviePagination>, t: Throwable) {
                onError()
            }

        })
    }

    private fun onError() {
        Toast.makeText(this, "A conexão falhou", Toast.LENGTH_SHORT).show()
    }

}