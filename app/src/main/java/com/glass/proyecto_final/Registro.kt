package com.glass.proyecto_final

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class Registro : Activity() {

    private lateinit var preferencias: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        preferencias = this.getSharedPreferences("misPrefs",0)
        editor = preferencias.edit()

        val button = findViewById<Button>(R.id.btnRegistrar)
        val usuario = findViewById<EditText>(R.id.etUsuarioCine)
        val password = findViewById<EditText>(R.id.etContraseña)
        val edad = findViewById<EditText>(R.id.etEdad)
        val Sexo = findViewById<EditText>(R.id.etSexo)

        button.setOnClickListener{
            editor.putString("usuario",usuario.text.toString()).commit()
            editor.putString("password", password.text.toString()).commit()
            //revisar si deben o no integrarse
            editor.putString("edad",edad.text.toString()).commit()
            editor.putString("Sexo",Sexo.text.toString()).commit()
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_LONG).show()

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}

