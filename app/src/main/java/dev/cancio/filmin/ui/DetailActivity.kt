package dev.cancio.filmin.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.cancio.filmin.R
import dev.cancio.filmin.data.Movie

class DetailActivity : AppCompatActivity() {

    companion object{
        fun getStartIntent(context: Context, movie: Movie) =
            Intent(context,DetailActivity::class.java)
                .putExtra("MOVIE",movie)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}