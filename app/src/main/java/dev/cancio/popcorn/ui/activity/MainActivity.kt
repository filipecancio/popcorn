package dev.cancio.popcorn.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.popcorn.MyApplication
import dev.cancio.popcorn.data.repository.MovieRepository
import dev.cancio.popcorn.data.model.MoviePagination
import dev.cancio.popcorn.databinding.ActivityMainBinding
import dev.cancio.popcorn.ui.adapter.MovieItemAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieApi :MovieRepository

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieItemAdapter: MovieItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MyApplication().appComponent.inject(this)
        getMoviesList(binding,this)
    }

    private fun getMoviesList(binding: ActivityMainBinding,context:Context){
        movieApi.getMoviesList().enqueue(object : Callback<MoviePagination>{
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