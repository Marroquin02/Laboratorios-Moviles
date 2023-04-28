package com.avsc.laboratorio_05.repositories


import com.avsc.laboratorio_05.data.model.MovieModel


class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies
    fun addMovies(movie: MovieModel) = movies.add(movie)
}