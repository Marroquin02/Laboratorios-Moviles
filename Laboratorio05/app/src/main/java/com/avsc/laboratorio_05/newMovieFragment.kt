package com.avsc.laboratorio_05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [newMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class newMovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var btnSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
       // listeners()
    }

    private fun bind(){
        btnSubmit = view?.findViewById(R.id.btn_submit) as Button
    }

    //private fun listeners(){
       // btnSubmit.setOnClickListener{
         //   it.findNavController().navigate(R.id.action_add_Movie_Fragment_to_billBoard_Fragment)
       // }
    //}
}