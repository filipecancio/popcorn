package dev.cancio.popcorn.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.cancio.popcorn.MyApplication
import dev.cancio.popcorn.R
import dev.cancio.popcorn.data.repository.MovieRepository
import dev.cancio.popcorn.data.model.MoviePagination
import dev.cancio.popcorn.databinding.ActivityMainBinding
import dev.cancio.popcorn.ui.adapter.MovieItemAdapter
import dev.cancio.popcorn.ui.fragment.HomeFragment
import dev.cancio.popcorn.ui.fragment.LikeFragment
import dev.cancio.popcorn.ui.fragment.NoneFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieApi :MovieRepository

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieItemAdapter: MovieItemAdapter
    lateinit var navController : NavController
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //startHomeFragment()
        setNavigationController()

        MyApplication().appComponent.inject(this)
        //getMoviesList(binding,this)
    }

    private fun setNavigationController(){
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        bottomNavigationView = findViewById(R.id.bottom_nav_bar)
        bottomNavigationView.setupWithNavController(navController)

    }

    /*private fun getMoviesList(binding: ActivityMainBinding,context:Context){
        movieApi.getMoviesList().enqueue(object : Callback<MoviePagination>{
            override fun onResponse(
                call: Call<MoviePagination>,
                response: Response<MoviePagination>
            ) {
                if(response.isSuccessful){
                    val moviePagination = response.body()
                    moviePagination?.apply {
                        movieItemAdapter = MovieItemAdapter(context, results)
                        recyclerView = binding.mainRecyclerview
                        val manager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

                        recyclerView.apply {
                            layoutManager = manager
                            adapter = movieItemAdapter
                        }
                    }
                }else{
                    onError()
                }
            }

            override fun onFailure(call: Call<MoviePagination>, t: Throwable) {
                onError()
            }

        })
    }*/

    private fun startHomeFragment() {
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, homeFragment)
            .commit()
    }

    private fun replaceFragment(fragmentId: Int, fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(fragmentId, fragment)
            .commit()
        return true
    }

    private fun onError() {
        Toast.makeText(this, "A conexão falhou", Toast.LENGTH_SHORT).show()
    }


}