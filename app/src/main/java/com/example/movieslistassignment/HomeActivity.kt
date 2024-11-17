package com.example.movieslistassignment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieslistassignment.adapter.MovieAdapter
import com.example.movieslistassignment.databinding.ActivityHomeBinding
import com.example.movieslistassignment.databinding.GenreItemBinding
import com.example.movieslistassignment.model.GenreModel
import com.example.movieslistassignment.model.MovieModel
import com.example.movieslistassignment.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var genres:List<GenreModel> = emptyList()
    private var movies:List<MovieModel> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("HOME ACTIVITY ", "Inside here")

        fetchMovieAndGenreData()

        Log.d("HOME ACTIVITY ", "Fetch call executed")

        val movieAdapter = MovieAdapter(this,movies)
        binding.topWatchRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.topWatchRecyclerView.adapter = movieAdapter
    }

    private fun fetchMovieAndGenreData() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.api.getMovieResponse()
                withContext(Dispatchers.Main) {
                    genres = response.genres
                    movies = response.movies

                    Log.d("Home Activity", "Got data ${movies[0]}")
                    populateGenres()

                    val movieAdapter = MovieAdapter(this@HomeActivity, movies)
                    binding.topWatchRecyclerView.adapter = movieAdapter
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.e("NETWORK ERROR", "${e.message}")
                }
            }
        }
    }
    private fun populateGenres(){
        binding.genreContainer.removeAllViews()

        for(genre in genres){
            val genreBinding = GenreItemBinding.inflate(layoutInflater,binding.genreContainer,false)

            val genreNameTxtView = genreBinding.genreNameTxtView
            val genrePosterImgView = genreBinding.genrePosterImgView

            genreNameTxtView.text = genre.name

            Glide.with(this)
                .load(genre.posterUrl)
                .placeholder(R.drawable.poster_placeholder)
                .into(genrePosterImgView)

            binding.genreContainer.addView(genreBinding.root)
        }
    }
}