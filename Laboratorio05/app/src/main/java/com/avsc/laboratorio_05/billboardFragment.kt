package com.avsc.laboratorio_05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [billboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class billboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var buttonFragmentNewMovie: FloatingActionButton
    private lateinit var cardViewFragmentStarWars: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()


    }

    private fun bind(){
        cardViewFragmentStarWars = view?.findViewById(R.id.card_view_star_wars) as CardView
        buttonFragmentNewMovie = view?.findViewById(R.id.btn_link_new_movie) as FloatingActionButton
    }

    private fun listeners(){
        buttonFragmentNewMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

        cardViewFragmentStarWars.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }
    }
}