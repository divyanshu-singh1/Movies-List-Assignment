package com.example.movieslistassignment.network


import com.example.movieslistassignment.model.MovieResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiService {
    @GET("v3/70753dcd-3fa9-4152-84d3-b93267ecdfb3")
    suspend fun getMovieResponse() : MovieResponseModel
}