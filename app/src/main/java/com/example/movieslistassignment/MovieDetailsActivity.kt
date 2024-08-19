package com.example.movieslistassignment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movieslistassignment.databinding.ActivityMovieDetailsBinding
import com.example.movieslistassignment.model.MovieModel

class MovieDetailsActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("Movie Details","CAME HERE")

        val movie = intent.getSerializableExtra("MOVIE") as MovieModel

        Log.d("Movie Details","Got Movie ${movie}")
        movie?.let {
            binding.titleTextView.text = it.title
            binding.yearTextView.text = "Year: ${it.year}"
            binding.runtimeTextView.text = "Runtime: ${it.runtime}"
            binding.directorTxtView.text = "Director: ${it.director}"
            binding.actorTxtView.text = "Actors: ${it.actors}"
            binding.descriptionTextView.text = it.plot
            Glide.with(this)
                .load(it.posterUrl)
                .placeholder(R.drawable.poster_placeholder)
                .into(binding.posterImageView)
        }
    }
}