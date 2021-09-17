package dev.cancio.popcorn.ui.vh

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.cancio.popcorn.R
import dev.cancio.popcorn.data.model.dataclass.Movie
import dev.cancio.popcorn.databinding.MovieItemBinding
import dev.cancio.popcorn.ui.fragment.DetailFragment

class MovieItemViewHolder(
    private val itemMovieBinding: MovieItemBinding,
    private val fragmentManager: FragmentManager?
) : View.OnClickListener, RecyclerView.ViewHolder(itemMovieBinding.root) {

    private lateinit var movie: Movie

    init {
        itemMovieBinding.root.setOnClickListener(this)
    }

    fun bind(movie: Movie) {
        this.movie = movie
        with(itemMovieBinding) {
            imageViewPoster.load(movie.poster)
            textViewTitle.text = movie.title
            textViewRating.text = movie.voteAverage.toString()
        }
    }

    private fun ImageView.load(path: String) = Glide.with(this).load(path).into(this)

    override fun onClick(view: View?) {
        view?.let {
            val newFragment = DetailFragment.newInstance(movie.id)
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.nav_host_fragment,newFragment)
                ?.commit()
        }
    }
}