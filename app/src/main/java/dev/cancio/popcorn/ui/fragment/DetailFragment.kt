package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import dev.cancio.popcorn.R
import dev.cancio.popcorn.base.BaseFragment
import dev.cancio.popcorn.data.model.dataclass.Credit
import dev.cancio.popcorn.data.model.dataclass.MovieDetail
import dev.cancio.popcorn.databinding.FragmentDetailBinding
import dev.cancio.popcorn.di.DetailModule
import dev.cancio.popcorn.presenter.DetailPresenter
import dev.cancio.popcorn.ui.adapter.CastItemAdapter
import javax.inject.Inject

private const val MOVIE_EXTRA = "MOVIE"

class DetailFragment : BaseFragment(), DetailPresenter.View {

    @Inject
    lateinit var presenter: DetailPresenter

    override val binding: FragmentDetailBinding by lazy {
        FragmentDetailBinding.inflate(
            layoutInflater
        )
    }


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
        getApplicationComponent().plus(DetailModule(this)).inject(this)
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

        binding.buttonLike.setOnClickListener {
            presenter.likeMovie()
        }
    }

    override fun inflateRecyclerView(credit: Credit) {

        val manager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        with(binding) {
            textviewDetailStarring.text =
                getString(R.string.starring_name, credit.cast[0].name)
            textviewDetailDirector.text = getString(R.string.director_name, credit.crew[0].name)

            recyclerviewDetailCast.layoutManager = manager
            recyclerviewDetailCast.adapter = CastItemAdapter(credit.cast)
        }
    }

    override fun bindDetails(details: MovieDetail) {
        with(binding) {
            imageViewDetailPosterBackdrop.load(details.backdrop)
            imageViewDetailPoster.load(details.poster)
            textviewDetailTitle.text = details.title
            textviewDetailOverview.text = details.overview
            textviewDetailRating.text = details.voteAverage.toString()
        }
    }

    private fun ImageView.load(path: String) = Glide.with(this).load(path).into(this)


    override fun onError() {
        Toast.makeText(this.context, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }
}