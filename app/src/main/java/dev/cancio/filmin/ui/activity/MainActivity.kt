package dev.cancio.filmin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.filmin.R
import dev.cancio.filmin.data.Movie
import dev.cancio.filmin.data.movies
import dev.cancio.filmin.repository.RetrofitClient
import dev.cancio.filmin.ui.adapter.MovieItemAdapter

class MainActivity : AppCompatActivity() {

    private val client by lazy { RetrofitClient.getInstance() }
    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.main_recyclerview) }

    val liveList = MutableLiveData<List<Movie>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = MovieItemAdapter(this@MainActivity, movies)
    }

}