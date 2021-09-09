package dev.cancio.filmin.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dev.cancio.filmin.MyApplication
import dev.cancio.filmin.data.model.Movie
import dev.cancio.filmin.databinding.ActivityDetailBinding
import dev.cancio.filmin.di.DetailModule
import dev.cancio.filmin.di.HomeModule
import dev.cancio.filmin.presenter.DetailPresenter
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailPresenter.View {

    override val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(
            layoutInflater
        )
    }

    @Inject
    lateinit var presenter: DetailPresenter

    private lateinit var backdrop: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView

    companion object {
        fun getStartIntent(context: Context, movie: Movie) =
            Intent(context, DetailActivity::class.java)
                .putExtra("MOVIE", movie)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MyApplication().appComponent.plus(DetailModule(this)).inject(this)
        bindViews()
    }

    override fun bindViews() {
        binding.apply {
            backdrop = imageViewDetailBackdrop
            title = textViewDetailTitle
            overview = textViewDetailOverview
        }

        val movie = intent.extras?.getSerializable("MOVIE") as Movie

        Glide.with(this).load(movie.backdrop).into(backdrop)
        title.text = movie.title
        overview.text = movie.overview
    }
}