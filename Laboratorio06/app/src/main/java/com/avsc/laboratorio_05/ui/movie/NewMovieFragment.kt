package com.avsc.laboratorio_05.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.avsc.laboratorio_05.R
import com.avsc.laboratorio_05.data.model.MovieModel


/**
 * A simple [Fragment] subclass.
 * Use the [newMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class newMovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var descriptionEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()
    }

    private fun bind() {
        btnSubmit = view?.findViewById(R.id.btn_submit) as Button
        nameEditText = view?.findViewById(R.id.edit_text_name) as EditText
        categoryEditText = view?.findViewById(R.id.edit_text_category) as EditText
        descriptionEditText = view?.findViewById(R.id.edit_text_description) as EditText
        qualificationEditText = view?.findViewById(R.id.edit_text_calification) as EditText

    }

    private fun listeners() {

        btnSubmit.setOnClickListener {
            val newMovie:MovieModel =  MovieModel(
                nameEditText.text.toString(),
                categoryEditText.text.toString(),
                descriptionEditText.text.toString(),
                qualificationEditText.text.toString()
            )
            movieViewModel.addMovies(newMovie)
            it.findNavController().navigate(R.id.action_newMovieFragment_to_billboardFragment)

            Log.d("NewMovieFragment", movieViewModel.getMovies().toString())
        }
    }
}