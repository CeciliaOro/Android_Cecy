package com.glass.proyecto_final


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentOne : Fragment() {
    private lateinit var listView:RecyclerView
    private lateinit var movies: List<Movie>

    companion object {
        fun newInstance(): FragmentOne {
            return FragmentOne()
        }
    }

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_fragment_one, container, false)


        listView = view.findViewById(R.id.listView)
        val llm = LinearLayoutManager(view.context)
        llm.orientation = VERTICAL
        listView.layoutManager = llm

        val retrofit = initMovieClient()
        val api = retrofit.create(MovieApi::class.java)
        val call = api.movies

        call.enqueue(object: Callback<List<Movie>>{
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                println("error descargando datos")
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movies = response.body()!!
                println(movies.size)
                loadData()
                listView.adapter?.notifyDataSetChanged()
            }

        })

        movies = listOf()

        listView.adapter = MovieAdapter(movies, view.context)
        return view

    }

    fun loadData(){
        listView.adapter = MovieAdapter(movies, view!!.context)
    }
}



