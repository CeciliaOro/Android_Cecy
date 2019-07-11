package com.glass.proyecto_final

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun initMovieClient(): Retrofit{
    val API_BASE_URL = "https://gist.githubusercontent.com"

    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BASIC

    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(logging)

    val retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build()
    return retrofit
}
