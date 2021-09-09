package dev.cancio.filmin.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.filmin.MyApplication
import dev.cancio.filmin.data.model.Movie
import dev.cancio.filmin.databinding.ActivityHomeBinding
import dev.cancio.filmin.di.HomeModule
import dev.cancio.filmin.presenter.HomePresenter
import dev.cancio.filmin.ui.adapter.MovieItemAdapter
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomePresenter.View {

    @Inject
    lateinit var presenter: HomePresenter

    override val binding: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieItemAdapter: MovieItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MyApplication().appComponent.plus(HomeModule(this)).inject(this)
        bindViews()
    }

    override fun bindViews() {
        presenter.getMoviesList()
    }

    override fun inflateRecyclerView(movieList: List<Movie>) {
        movieItemAdapter = MovieItemAdapter(this, movieList)
        recyclerView = binding.mainRecyclerview
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.apply {
            layoutManager = manager
            adapter = movieItemAdapter
        }
    }

    override fun onError() {
        Toast.makeText(this, "A conexão falhou", Toast.LENGTH_SHORT).show()
    }
}