package dev.cancio.filmin.ui.vh

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.cancio.filmin.R
import dev.cancio.filmin.data.Movie
import dev.cancio.filmin.ui.activity.DetailActivity

class MovieItemViewHolder(
    itemView: View
) : View.OnClickListener, RecyclerView.ViewHolder(itemView) {

    private lateinit var movie: Movie

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(movie: Movie) {
        this.movie = movie
        itemView.apply {
            val poster = findViewById<ImageView>(R.id.imageView_poster)
            val title = findViewById<TextView>(R.id.textView_title)
            val voteAverage = findViewById<TextView>(R.id.textView_rating)

            Glide.with(this).load(movie.poster).into(poster)
            title.text = movie.title
            voteAverage.text = movie.voteAverage.toString()
        }
    }

    override fun onClick(view: View?) {
        view?.let {
            val context = it.context
            val intent = DetailActivity.getStartIntent(context, movie)
            context.startActivity(intent)
        }
    }
}