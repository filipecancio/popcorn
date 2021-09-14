package dev.cancio.popcorn.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dev.cancio.popcorn.data.model.Movie
import dev.cancio.popcorn.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var backdrop: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView

    companion object{
        fun getStartIntent(context: Context, movie: Movie) =
            Intent(context, DetailActivity::class.java)
                .putExtra("MOVIE",movie)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

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