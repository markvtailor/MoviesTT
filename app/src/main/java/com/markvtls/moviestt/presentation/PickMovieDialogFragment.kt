package com.markvtls.moviestt.presentation

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.markvtls.moviestt.R
import com.markvtls.moviestt.databinding.PickMovieFragmentBinding
import com.markvtls.moviestt.domain.model.MovieDomain
import kotlinx.coroutines.launch

class PickMovieDialogFragment: DialogFragment() {

    private var _binging: PickMovieFragmentBinding? = null
    private val binding get() = _binging

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binging = PickMovieFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("MovieTitle")!!
        bind(title)
    }
    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        _binging = null
    }

    private fun bind(movieTitle: String) {
        binding?.apply {
            dialogText.text = getString(R.string.dialog, movieTitle)
        }
    }
}