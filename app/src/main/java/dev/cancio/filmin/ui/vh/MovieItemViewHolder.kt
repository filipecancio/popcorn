package dev.cancio.filmin.ui.vh

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.cancio.filmin.data.Movie
import dev.cancio.filmin.databinding.MovieItemBinding
import dev.cancio.filmin.ui.activity.DetailActivity

class MovieItemViewHolder(
    private val itemMovieBinding: MovieItemBinding
) : View.OnClickListener, RecyclerView.ViewHolder(itemMovieBinding.root) {

    private lateinit var movie: Movie

    init {
        itemMovieBinding.root.setOnClickListener(this)
    }

    fun bind(movie: Movie) {
        this.movie = movie
        itemMovieBinding.apply {
            Glide.with(this.root).load(movie.poster).into(imageViewPoster)
            textViewTitle.text = movie.title
            textViewRating.text = movie.voteAverage.toString()
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