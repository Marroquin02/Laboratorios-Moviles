package com.ironcityrp.fragmentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_NAME = "ARG_NAME"
private const val ARG_LASTNAME = "ARG_LASTNAME"

class GreetingFragment : Fragment() {
    private var name: String? = null
    private var lastname: String? = null

    private lateinit var greetingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            lastname = it.getString(ARG_LASTNAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_greeting, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        greetingTextView = view.findViewById(R.id.greeting_textView)
        greetingTextView.text = getString(
            R.string.text_name_lastname,
            name ?: "Carlos", lastname ?: "Marroquin"")
    }

    companion object {
        fun newInstance(name: String, lastname: String) =
            GreetingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_LASTNAME, lastname)
                }
            }
    }
}