package com.example.movieslistassignment.model

import java.io.Serializable
data class MovieModel(
    val id: Int,
    val title: String,
    val year: String,
    val runtime: String,
    val genres: List<String>,
    val director: String,
    val actors: String,
    val plot: String,
    val posterUrl: String
): Serializable