package dev.cancio.popcorn.ui.vh

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.cancio.popcorn.R
import dev.cancio.popcorn.data.model.entity.Movie
import dev.cancio.popcorn.databinding.MovieItemBinding
import dev.cancio.popcorn.ui.fragment.DetailFragment

class MovieItemViewHolder(
    private val itemMovieBinding: MovieItemBinding,
    private val fragmentManager: FragmentManager?
) : View.OnClickListener, RecyclerView.ViewHolder(itemMovieBinding.root) {

    private lateinit var movieResponse: Movie

    init {
        itemMovieBinding.root.setOnClickListener(this)
    }

    fun bind(movieResponse: Movie) {
        this.movieResponse = movieResponse
        with(itemMovieBinding) {
            imageViewPoster.load(movieResponse.poster)
            textViewTitle.text = movieResponse.title
            textViewRating.text = movieResponse.voteAverage.toString()
        }
    }

    private fun ImageView.load(path: String) = Glide.with(this).load(path).into(this)

    override fun onClick(view: View?) {
        view?.let {
            val newFragment = DetailFragment.newInstance(movieResponse.id)
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.nav_host_fragment,newFragment)
                ?.commit()
        }
    }
}