package dev.cancio.filmin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.filmin.R
import dev.cancio.filmin.data.movies
import dev.cancio.filmin.ui.adapter.MovieItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val movieItemAdapter = MovieItemAdapter(this, movies)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.main_recyclerview)
        val manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recyclerView.apply {
            layoutManager = manager
            adapter = movieItemAdapter
        }
    }

}