package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import dev.cancio.popcorn.base.BaseFragment
import dev.cancio.popcorn.data.model.entity.Movie
import dev.cancio.popcorn.databinding.FragmentLikeBinding
import dev.cancio.popcorn.di.LikeModule
import dev.cancio.popcorn.presenter.LikePresenter
import dev.cancio.popcorn.ui.adapter.MovieItemAdapter
import javax.inject.Inject

class LikeFragment : BaseFragment(), LikePresenter.View {

    @Inject
    lateinit var presenter: LikePresenter

    override val binding: FragmentLikeBinding by lazy {
        FragmentLikeBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getApplicationComponent().plus(LikeModule(this)).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindViews()
        return binding.root
    }

    override fun bindViews() {
        presenter.getLikedMovies()
    }

    override fun inflateRecyclerView(movieList: List<Movie>) {
        val fragmentManager = activity?.supportFragmentManager
        val context = this.requireContext()
        val recyclerView = binding.recyclerviewLikeMovies

        with(recyclerView) {
            layoutManager = GridLayoutManager(context, 3)
            adapter = MovieItemAdapter(context, movieList, fragmentManager)
        }

    }
}