package com.example.dazn_movie_player

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dazn_movie_player.databinding.MovieItemBinding
import com.example.dazn_movie_player.models.Tile

class TileAdapter(
    private val movies: List<Tile>
) : RecyclerView.Adapter<TileAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindMovie(movie: Tile) {
            /*binding.movieTitle.text = movie.Title
            binding.movieReleaseDate.text = movie.Description
            Glide.with(itemView.context).load(movie.Url).into(binding.moviePosterIv)*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))

    }
}
