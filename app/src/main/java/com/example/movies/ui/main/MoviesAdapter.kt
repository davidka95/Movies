package com.example.movies.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.movies.R
import com.example.movies.model.Movie
import kotlinx.android.synthetic.main.movie_list_item.view.*
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.util.Base64










class MoviesAdapter constructor(
    private val context: Context,
    private var movies: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){


    private var clickListener: ClickListener? = null


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.movie_list_item, viewGroup, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.itemView.setOnClickListener {
            clickListener?.onItemClick(movie)
        }


        if (movie.imageBase64.isEmpty()) {
                holder.ivPoster.setImageDrawable(context.resources.getDrawable(R.drawable.image_placeholder))
        } else {
            val decodedString = Base64.decode(movie.imageBase64, Base64.DEFAULT)
            val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)

            holder.ivPoster.setImageBitmap(decodedByte)
        }


        holder.tvTitle.text = movie.title
        holder.tvReleaseDate.text = movie.releaseDate?.toString() ?: ""
    }

    fun setOnClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun getItemCount() = movies.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var ivPoster: ImageView = view.ivPoster
        var tvTitle: TextView = view.tvTitle
        var tvReleaseDate: TextView = view.tvReleaseDate
    }
}

interface ClickListener {
    fun onItemClick(movie: Movie);
}
