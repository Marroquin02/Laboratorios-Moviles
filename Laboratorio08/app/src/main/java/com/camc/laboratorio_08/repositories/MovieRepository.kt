package com.camc.laboratorio_08.repositories


import com.camc.laboratorio_08.data.model.MovieModel


class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies
    fun addMovies(movie: MovieModel) = movies.add(movie)
}