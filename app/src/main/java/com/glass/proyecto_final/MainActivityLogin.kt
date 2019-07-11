package com.glass.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        val bundle  = intent.extras
        val usuario = bundle?.getString("usuario")
        println(usuario)
        val textView = findViewById<TextView>(R.id.txtUsuario)

        textView.setText(usuario)

    }
}
