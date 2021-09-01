package dev.cancio.filmin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.filmin.MyApplication
import dev.cancio.filmin.data.model.Movie
import dev.cancio.filmin.databinding.ActivityMainBinding
import dev.cancio.filmin.presenter.MainPresenter
import dev.cancio.filmin.ui.adapter.MovieItemAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.View {

    @Inject
    lateinit var presenter: MainPresenter

    override val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieItemAdapter: MovieItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MyApplication().appComponent.inject(this)
        bindViews()
    }

    override fun bindViews() {
        presenter.getMoviesList(this)
    }

    override fun inflateRecyclerView(movieList: List<Movie>){
        movieItemAdapter = MovieItemAdapter(this, movieList)
        recyclerView = binding.mainRecyclerview
        val manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recyclerView.apply {
            layoutManager = manager
            adapter = movieItemAdapter
        }
    }





}