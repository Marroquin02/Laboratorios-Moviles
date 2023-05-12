package com.camc.laboratorio_08.ui.movie.billboard.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.camc.laboratorio_08.data.model.MovieModel
import com.camc.laboratorio_08.databinding.MovieItemBinding


class MovieRecyclerViewAdapter(
    private val clickListener: (MovieModel) -> Unit
) : RecyclerView.Adapter<MovieRecycleViewHolder>() {
    private val movies = ArrayList<MovieModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecycleViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecycleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecycleViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(movieslist: List<MovieModel>){
        movies.clear()
        movies.addAll(movieslist)
    }
}