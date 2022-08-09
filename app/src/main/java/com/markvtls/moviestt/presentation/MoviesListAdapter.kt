package com.markvtls.moviestt.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.markvtls.moviestt.R
import com.markvtls.moviestt.databinding.MoviesListItemFragmentBinding
import com.markvtls.moviestt.domain.model.MovieDomain

class MoviesListAdapter(private val context: Context,private val onItemClick: (MovieDomain) -> Unit): ListAdapter<MovieDomain, MoviesListAdapter.MovieViewHolder>(
    DiffCallback
) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val holder = MovieViewHolder(
            context,
            MoviesListItemFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            )
        )
        holder.itemView.setOnClickListener {
            onItemClick(getItem(holder.adapterPosition))
        }
        return holder
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieViewHolder(private val context: Context,private val binding: MoviesListItemFragmentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieDomain) {
            binding.apply {
                binding.movieHeader.text = context.getString(R.string.movie_header, movie.title ,movie.releaseYear.toString())
                binding.directorName.text = movie.directorName
                binding.actors.text = movie.actors
            }
        }
    }

    companion object {
        private val DiffCallback = object: DiffUtil.ItemCallback<MovieDomain>() {
            override fun areItemsTheSame(oldItem: MovieDomain, newItem: MovieDomain): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: MovieDomain, newItem: MovieDomain): Boolean {
                return oldItem.title == newItem.title
            }

        }
    }
}

