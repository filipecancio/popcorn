package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import dev.cancio.popcorn.R
import dev.cancio.popcorn.base.BaseFragment
import dev.cancio.popcorn.data.model.dataclass.MovieResponse
import dev.cancio.popcorn.databinding.FragmentHomeBinding
import dev.cancio.popcorn.di.HomeModule
import dev.cancio.popcorn.ui.adapter.MovieItemAdapter
import dev.cancio.popcorn.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: HomeViewModel

    val binding: FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getApplicationComponent().plus(HomeModule(this)).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindViews()
        return binding.root
    }

    private fun bindViews() {
        viewModel.getMoviesList()
        viewModel.movieList.observe(viewLifecycleOwner, {
            inflateRecyclerView(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, {
            onError()
        })
        viewModel.tredingMovie.observe(viewLifecycleOwner,{
            inflateDiscoverPoster(it)
        })
    }

    private fun inflateRecyclerView(movieResponseList: List<MovieResponse>) {
        val fragmentManager = activity?.supportFragmentManager
        val context = this.requireContext()
        val recyclerView = binding.recyclerviewReleasesItems
        val movieList = bindResponse(movieResponseList)

        with(recyclerView) {
            layoutManager = GridLayoutManager(context, 3)
            adapter = MovieItemAdapter(context, movieList, fragmentManager)
        }
    }

    private fun inflateDiscoverPoster(movieResponse: MovieResponse){
        val post = binding.imageviewDiscoverPost
        post.load(movieResponse.backdrop)
        post.setOnClickListener{
            val newFragment = DetailFragment.newInstance(movieResponse.id)
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.nav_host_fragment,newFragment)
                ?.commit()
        }
    }

    private fun ImageView.load(path: String) = Glide.with(this).load(path).into(this)

    private fun bindResponse(movieList: List<MovieResponse>) = movieList.map { it.toEntity() }

    private fun onError() {
        Toast.makeText(this.context, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }

}