package dev.cancio.filmin.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import dev.cancio.filmin.R
import dev.cancio.filmin.data.Movie

class DetailActivity : AppCompatActivity() {

    companion object{
        fun getStartIntent(context: Context, movie: Movie) =
            Intent(context, DetailActivity::class.java)
                .putExtra("MOVIE",movie)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val backdrop = findViewById<ImageView>(R.id.imageView_detail_backdrop)
        val title = findViewById<TextView>(R.id.textView_detail_title)
        val overview = findViewById<TextView>(R.id.textView_detail_overview)

        val movie = intent.extras?.getSerializable("MOVIE") as Movie

        Glide.with(this).load(movie.backdrop).into(backdrop)
        title.text = movie.title
        overview.text = movie.overview
    }
}