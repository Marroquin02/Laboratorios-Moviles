package com.camc.laboratorio_07.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.camc.laboratorio_07.databinding.FragmentNewMovieBinding


/**
 * A simple [Fragment] subclass.
 * Use the [newMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class NewMovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding :FragmentNewMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }
    private fun observerStatus(){
        movieViewModel.status.observe(viewLifecycleOwner) {
                status -> when{
            status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                Log.d(APP_TAG, status)
                movieViewModel.clearStatus() }
            status.equals(MovieViewModel.MOVIE_CREATED) -> {
                Log.d(APP_TAG, status)
                Log.d(APP_TAG, movieViewModel.getMovies().toString())

                movieViewModel.clearStatus()
                findNavController().popBackStack() }
        }
        }
    }

    companion object {
        const val APP_TAG = "NewMovieFragment"
    }
}