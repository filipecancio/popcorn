package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.popcorn.MyApplication
import dev.cancio.popcorn.R
import dev.cancio.popcorn.data.model.dataclass.Movie
import dev.cancio.popcorn.databinding.FragmentHomeBinding
import dev.cancio.popcorn.di.HomeModule
import dev.cancio.popcorn.presenter.HomePresenter
import dev.cancio.popcorn.ui.adapter.MovieItemAdapter
import javax.inject.Inject

class HomeFragment : Fragment(), HomePresenter.View  {

    @Inject
    lateinit var presenter: HomePresenter

    override val binding: FragmentHomeBinding by lazy { FragmentHomeBinding .inflate(layoutInflater) }

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieItemAdapter: MovieItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication().appComponent.plus(HomeModule(this)).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindViews()
        return binding.root
    }

    override fun bindViews() {
        presenter.getMoviesList()
    }

    override fun inflateRecyclerView(movieList: List<Movie>) {
        val fragmentManager = activity?.supportFragmentManager
        movieItemAdapter = MovieItemAdapter(this.requireContext(), movieList,fragmentManager)
        recyclerView = binding.mainRecyclerview
        val manager = GridLayoutManager(this.context, 3)

        recyclerView.apply {
            layoutManager = manager
            adapter = movieItemAdapter
        }
    }

    override fun onError() {
        Toast.makeText(this.context, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }

}