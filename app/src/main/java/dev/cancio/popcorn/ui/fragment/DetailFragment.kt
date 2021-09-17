package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
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
import dev.cancio.popcorn.data.model.dataclass.Credit
import dev.cancio.popcorn.data.model.dataclass.MovieDetail
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

    private var movieId: Int = 0
    private lateinit var backdrop: ImageView
    private lateinit var poster: ImageView
    private lateinit var title: TextView
    private lateinit var rating: TextView
    private lateinit var overview: TextView
    private lateinit var crew: TextView
    private lateinit var cast: TextView

    companion object {
        @JvmStatic
        fun newInstance(movieId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(MOVIE_EXTRA, movieId)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getInt(MOVIE_EXTRA)
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

        val movieId = arguments?.getSerializable(MOVIE_EXTRA) as Int

        presenter.apply {
            getCredit(movieId)
            getMovieDetail(movieId)
        }

    }

    override fun inflateRecyclerView(credit: Credit) {
        castAdapter = CastItemAdapter(credit.cast)
        binding.apply {
            recyclerView = castRecyclerview
            cast = textViewDetailStarring
            crew =  textViewDetailDirector

        }

        cast.text = getString(R.string.starring_name,credit.cast[0].name)
        crew.text = getString(R.string.director_name,credit.crew[0].name)

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
            poster = imageViewDetailPoster
            rating = textViewDetailRating
        }

        Glide.with(this).load(details.backdrop).into(backdrop)
        Glide.with(this).load(details.poster).into(poster)
        title.text = details.title
        overview.text = details.overview
        rating.text = details.voteAverage.toString()

    }


    override fun onError() {
        Toast.makeText(this.context, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }
}