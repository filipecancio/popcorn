package dev.cancio.popcorn.base

import androidx.appcompat.app.AppCompatActivity
import dev.cancio.popcorn.PopcornApplication

abstract class BaseActivity : AppCompatActivity() {

    fun getPopcornApplication() = applicationContext as PopcornApplication

}