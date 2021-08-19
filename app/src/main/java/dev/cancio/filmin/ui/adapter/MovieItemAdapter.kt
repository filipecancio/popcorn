package dev.cancio.filmin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.filmin.R
import dev.cancio.filmin.data.Movie
import dev.cancio.filmin.ui.vh.MovieItemViewHolder

class MovieItemAdapter(
    private val context: Context,
    private val movieList: List<Movie>
) : RecyclerView.Adapter<MovieItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.movie_item, parent, false)

        return MovieItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movieList.size
}