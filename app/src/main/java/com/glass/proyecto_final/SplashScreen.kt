package com.glass.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent

class SplashScreen : AppCompatActivity() {


    private var splashTimeOut: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            val loginIntent = Intent(this@SplashScreen,Registro::class.java)
            startActivity(loginIntent)
            finish()


        },splashTimeOut)



    }
}
