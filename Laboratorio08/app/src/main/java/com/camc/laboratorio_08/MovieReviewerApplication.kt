package com.camc.laboratorio_08

import android.app.Application
import com.camc.laboratorio_08.data.movies
import com.camc.laboratorio_08.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy{
        MovieRepository(movies)
    }
}