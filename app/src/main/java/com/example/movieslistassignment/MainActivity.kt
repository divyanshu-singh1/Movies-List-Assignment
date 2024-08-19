package com.example.movieslistassignment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.movieslistassignment.databinding.ActivityMainBinding
import retrofit2.Callback
import com.example.movieslistassignment.model.MovieResponseModel
import com.example.movieslistassignment.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpSplashScreen()
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
            },2000
        )
    }

    private fun setUpSplashScreen(){
        val gifImageView =  binding.homeGif
        Glide.with(this)
            .load("https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExM3dvc3hjOWJjaTZjMWlwbjZxdm5kcHc1Y3JtcWJ6bmhpNGhxcmM2ZyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/tmH5eUto7WumOdTvRG/giphy.gif")
            .into(gifImageView)

        Toast.makeText(this,"Made by Divyanshu Singh" ,Toast.LENGTH_SHORT).show()
    }
}