package dev.cancio.filmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import dev.cancio.filmin.data.Movie
import dev.cancio.filmin.repository.RetrofitClient
import dev.cancio.filmin.service.MovieService

class MainActivity : AppCompatActivity() {

    private val client by lazy { RetrofitClient.getInstance() }
    val liveList = MutableLiveData<List<Movie>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}