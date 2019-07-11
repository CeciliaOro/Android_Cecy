package com.glass.proyecto_final

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.glass.proyecto_final.dummy.DummyContent
import com.glass.proyecto_final.dummy.DummyContent.DummyItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [movieFragment.OnListFragmentInteractionListener] interface.
 */
class movieFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 2
    private lateinit var movies: List<Movie>
    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)

        val retrofit = initMovieClient()
        val api = retrofit.create(MovieApi::class.java)
        val call = api.movies


        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                call.enqueue(object: Callback<List<Movie>> {
                    override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                        println("error descargando datos")
                    }

                    override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                        movies = response.body()!!
                        layoutManager = when {
                            columnCount <= 1 -> LinearLayoutManager(context)
                            else -> GridLayoutManager(context, columnCount)
                        }
                        adapter = MymovieRecyclerViewAdapter(movies, listener)
                    }

                })

            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            movieFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
