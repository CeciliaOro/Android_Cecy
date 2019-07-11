package com.glass.proyecto_final


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class FragmentThree : Fragment() {

    companion object {
        fun newInstance(): FragmentThree {
            return FragmentThree()
        }
    }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            var view = inflater.inflate(R.layout.fragment_fragment_three, container, false)
            var button = view.findViewById<Button>(R.id.botonFragThree)

            button.setOnClickListener {
                Toast.makeText(view.context, "Permitir ubicación", Toast.LENGTH_LONG).show()
            }

            return view


        }


}
