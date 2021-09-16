package dev.cancio.popcorn.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.popcorn.data.model.dataclass.Movie
import dev.cancio.popcorn.databinding.MovieItemBinding
import dev.cancio.popcorn.ui.vh.MovieItemViewHolder

class MovieItemAdapter(
    private val context: Context,
    private val movieList: List<Movie>,
    private val fragmentManager: FragmentManager?
) : RecyclerView.Adapter<MovieItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieItemViewHolder(binding,fragmentManager)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movieList.size
}