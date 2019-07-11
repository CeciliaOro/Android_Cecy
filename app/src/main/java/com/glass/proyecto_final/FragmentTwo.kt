package com.glass.proyecto_final


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class FragmentTwo : Fragment() {


    companion object {
        fun newInstance () : FragmentTwo {
            return FragmentTwo()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_fragment_two, container, false)
        var button = view.findViewById<Button>(R.id.botonFragTwo)

        button.setOnClickListener {
            Toast.makeText(view.context, "Nombre del Contacto", Toast.LENGTH_LONG).show()
        }

        return view


    }


}
