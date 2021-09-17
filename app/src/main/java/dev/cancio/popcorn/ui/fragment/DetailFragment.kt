package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.cancio.popcorn.MyApplication
import dev.cancio.popcorn.R
import dev.cancio.popcorn.data.model.dataclass.Movie
import dev.cancio.popcorn.data.model.dataclass.MovieDetail
import dev.cancio.popcorn.data.model.dataclass.Person
import dev.cancio.popcorn.databinding.FragmentDetailBinding
import dev.cancio.popcorn.di.DetailModule
import dev.cancio.popcorn.presenter.DetailPresenter
import dev.cancio.popcorn.ui.adapter.CastItemAdapter
import javax.inject.Inject

private const val MOVIE_EXTRA = "MOVIE"

class DetailFragment : Fragment(), DetailPresenter.View {

    @Inject
    lateinit var presenter: DetailPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var castAdapter: CastItemAdapter

    override val binding: FragmentDetailBinding by lazy { FragmentDetailBinding.inflate(layoutInflater)}

    private lateinit var movieExtra: Movie
    private lateinit var backdrop: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView

    companion object {
        @JvmStatic
        fun newInstance(movie: Movie) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MOVIE_EXTRA, movie)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieExtra = it.getSerializable(MOVIE_EXTRA) as Movie
            Log.v("EXTRA", movieExtra.toString())
        }
        MyApplication().appComponent.plus(DetailModule(this)).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindViews()
        return binding.root
    }

    override fun bindViews() {

        val movie = arguments?.getSerializable(MOVIE_EXTRA) as Movie

        presenter.apply {
            getCredit(movie.id)
            getMovieDetail(movie.id)
        }

    }

    override fun inflateRecyclerView(cast: List<Person>) {
        castAdapter = CastItemAdapter(cast)
        recyclerView = binding.castRecyclerview
        val manager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.apply {
            layoutManager = manager
            adapter = castAdapter
        }
    }

    override fun bindDetails(details: MovieDetail) {
        binding.apply {
            backdrop = imageViewDetailBackdrop
            title = textViewDetailTitle
            overview = textViewDetailOverview
        }

        Glide.with(this).load(details.backdrop).into(backdrop)
        title.text = details.title
        overview.text = details.overview

    }


    override fun onError() {
        Toast.makeText(this.context, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }
}