package dev.cancio.filmin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.filmin.data.movies
import dev.cancio.filmin.databinding.ActivityMainBinding
import dev.cancio.filmin.ui.adapter.MovieItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val movieItemAdapter = MovieItemAdapter(this, movies)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.mainRecyclerview
        val manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recyclerView.apply {
            layoutManager = manager
            adapter = movieItemAdapter
        }
    }

}