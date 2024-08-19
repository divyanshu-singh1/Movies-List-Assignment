package com.example.movieslistassignment.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieslistassignment.MovieDetailsActivity
import com.example.movieslistassignment.R
import com.example.movieslistassignment.databinding.MovieItemBinding
import com.example.movieslistassignment.model.MovieModel

class MovieAdapter(private val context : Context, private val movies : List<MovieModel>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    inner class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        Log.d("MovieAdapter","$movie")
        val titleTxView  = holder.binding.titleTxtView
        val yearTxtView = holder.binding.yearTxtView
        val posterImgView = holder.binding.posterImgView
        titleTxView.text = movie.title
        yearTxtView.text = movie.year



        Glide.with(context)
            .load(movie.posterUrl)
            .placeholder(R.drawable.poster_placeholder)
            .into(posterImgView)

        holder.itemView.setOnClickListener {
            Log.d("MOVIE ADAPTER","HERE")
            val intent = Intent(context, MovieDetailsActivity::class.java).apply {
                putExtra("MOVIE", movie)
            }
            context.startActivity(intent)
        }
    }

}