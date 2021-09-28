package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import dev.cancio.popcorn.R
import dev.cancio.popcorn.base.BaseFragment
import dev.cancio.popcorn.data.model.dataclass.MovieResponse
import dev.cancio.popcorn.databinding.FragmentSearchBinding
import dev.cancio.popcorn.di.SearchModule
import dev.cancio.popcorn.presenter.SearchPresenter
import dev.cancio.popcorn.ui.adapter.MovieItemAdapter
import javax.inject.Inject

class SearchFragment : BaseFragment(), SearchPresenter.View {

    @Inject
    lateinit var presenter: SearchPresenter

    override val binding: FragmentSearchBinding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindViews()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getApplicationComponent().plus(SearchModule(this)).inject(this)
        binding.textinputedittextSearch.doOnTextChanged { textView, _, _, _ ->
            presenter.getMoviesList(textView.toString())
        }
    }

    override fun bindViews() {
        presenter.getMoviesList()
    }

    override fun inflateRecyclerView(movieResponseList: List<MovieResponse>) {
        val fragmentManager = activity?.supportFragmentManager
        val context = this.requireContext()
        val recyclerView = binding.recyclerviewSearchList
        val movieList = bindResponse(movieResponseList)

        with(recyclerView) {
            layoutManager = GridLayoutManager(context, 3)
            adapter = MovieItemAdapter(context, movieList, fragmentManager)
        }
    }

    override fun onError() {
        Toast.makeText(this.context, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }

    private fun bindResponse(movieList: List<MovieResponse>) = movieList.map { it.toEntity() }


}