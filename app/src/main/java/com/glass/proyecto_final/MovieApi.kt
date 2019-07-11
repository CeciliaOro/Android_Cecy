package com.glass.proyecto_final

import com.glass.proyecto_final.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @get:GET("saniyusuf/406b843afdfb9c6a86e25753fe2761f4/raw/523c324c7fcc36efab8224f9ebb7556c09b69a14/Film.JSON")
    val movies: Call<List<Movie>>
}

