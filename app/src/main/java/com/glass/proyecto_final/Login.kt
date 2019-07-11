package com.glass.proyecto_final


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    private lateinit var preferencias: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.botoninicio)
        val usuario = findViewById<EditText>(R.id.etUsuario)
        val password = findViewById<EditText>(R.id.etContraseña)

        preferencias = this.getSharedPreferences("misPrefs",0)
        editor = preferencias.edit()

        val usuarioSaved = preferencias.getString("usuario","")
        val passwordSaved = preferencias.getString("password","")

        button.setOnClickListener {
            println(usuario.text)
            println(password.text)
            println(usuarioSaved)
            println(passwordSaved)
            if(usuario.text.toString().equals(usuarioSaved) && password.text.toString().equals(passwordSaved)){
                Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show()
                val intent = Intent(this, TabActivity::class.java)
                intent.putExtra("usuario", usuario.text.toString())
                intent.putExtra("password", password.text.toString())
                startActivity(intent)

            }else{
                Toast.makeText(this, "Datos incorrectos, verifique", Toast.LENGTH_LONG).show()
            }
        }
    }
}
