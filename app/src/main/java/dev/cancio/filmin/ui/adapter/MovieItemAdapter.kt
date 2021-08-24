package dev.cancio.filmin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.filmin.R
import dev.cancio.filmin.data.model.Movie
import dev.cancio.filmin.databinding.MovieItemBinding
import dev.cancio.filmin.ui.vh.MovieItemViewHolder

class MovieItemAdapter(
    private val context: Context,
    private val movieList: List<Movie>
) : RecyclerView.Adapter<MovieItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movieList.size
}