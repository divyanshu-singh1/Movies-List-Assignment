package com.example.movieslistassignment.network


import com.example.movieslistassignment.model.MovieResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiService {
    @GET("v3/0d01502e-575e-41fb-b219-6c45ea72eedc")
    suspend fun getMovieResponse() : MovieResponseModel
}