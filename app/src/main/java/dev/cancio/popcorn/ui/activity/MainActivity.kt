package dev.cancio.popcorn.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.cancio.popcorn.MyApplication
import dev.cancio.popcorn.R
import dev.cancio.popcorn.databinding.ActivityMainBinding
import dev.cancio.popcorn.ui.adapter.MovieItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieItemAdapter: MovieItemAdapter
    lateinit var navController : NavController
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigationController()

        //MyApplication().appComponent.inject(this)
    }

    private fun setNavigationController(){
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        bottomNavigationView = findViewById(R.id.bottom_nav_bar)
        bottomNavigationView.setupWithNavController(navController)

    }

    private fun onError() {
        Toast.makeText(this, "A conexão falhou", Toast.LENGTH_SHORT).show()
    }


}