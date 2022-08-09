package com.markvtls.moviestt.presentation

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.markvtls.moviestt.R
import com.markvtls.moviestt.databinding.MoviesListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment: Fragment() {

    private val viewModel: MoviesViewModel by viewModels()
    private var _binding: MoviesListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MoviesListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitMoviesList()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun submitMoviesList() {
        val recyclerView = binding.moviesList
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        val moviesListAdapter = MoviesListAdapter(requireContext()) {
            pickMovie(it.title)
        }

        recyclerView.adapter = moviesListAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.movies.observe(viewLifecycleOwner) {
                    moviesListAdapter.submitList(it)
                }
            }
        }
    }
    private fun pickMovie(title: String) {
        val dialog = PickMovieDialogFragment()
        val args = Bundle()
        args.putString("MovieTitle", title)
        dialog.arguments = args
        dialog.show(childFragmentManager, "Pick Movie Dialog")
    }
}