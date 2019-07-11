package com.glass.proyecto_final

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


import com.glass.proyecto_final.movieFragment.OnListFragmentInteractionListener
import com.glass.proyecto_final.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_movieitem.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MymovieRecyclerViewAdapter(
    private val mValues: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MymovieRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movieitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]



        holder.mIdView.text = item.Title
        holder.mContentView.text = item.Year
        holder.mGenero.text = item.Genre
        Glide.with(holder.itemView.context).load(item.Images[0]).into(holder.imagen)
        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val mIdView: TextView = mView.titulo
        val mContentView: TextView = mView.año
        val mGenero: TextView = mView.genero
        val imagen: ImageView = mView.imagen

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
