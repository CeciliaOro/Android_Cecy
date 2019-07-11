package com.glass.proyecto_final

import android.content.Context
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(val items: List<Movie>, val context: Context) : RecyclerView.Adapter<MovieAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) : ItemViewHolder {
        val view = ItemViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.movie_item, parent, false))
        println(items.get(1).Title)

        return view
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(position,items [position])
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(pos: Int, movie: Movie) {

            itemView.titleMovie.text = movie.Title.toString()
            itemView.genreMovie.text = movie.Genre.toString()
            itemView.yearMovie.text = movie.Year.toString()
            //itemView.txtTitleFood.text = currentFood.food_name.toString()
            //itemView.txtMinRateFood.text = currentFood.min_rate.toString()
            //itemView.txtTotalRateFood.text = currentFood.total_rate.toString()
            //itemView.txtPriceFood.text = "$" +currentFood.price.toString()
            //itemView.txtPhoneFood.text = "(+52)" +currentFood.phone
            //itemView.imfFood.setImageResource (currentFood.image)

            //Què hacer cuando el usuario da click en la celda
            itemView.setOnClickListener { Toast.makeText (context, "Posicion="+pos,Toast.LENGTH_SHORT).show() }

        }
    }

}