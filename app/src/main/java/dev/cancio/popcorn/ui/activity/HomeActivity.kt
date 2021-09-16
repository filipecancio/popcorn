package dev.cancio.popcorn.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.popcorn.R
import dev.cancio.popcorn.data.model.dataclass.Movie
import dev.cancio.popcorn.databinding.ActivityHomeBinding
import dev.cancio.popcorn.presenter.HomePresenter
import dev.cancio.popcorn.ui.adapter.MovieItemAdapter
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

        //MyApplication().appComponent.plus(HomeModule(this)).inject(this)
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
        val errorMessage = getString(R.string.error_message)
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}