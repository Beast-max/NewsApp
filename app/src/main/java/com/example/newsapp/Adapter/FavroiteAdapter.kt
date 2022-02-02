package com.example.newsapp.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.Everything.Article
import com.example.newsapp.Database.Model
import com.example.newsapp.Extensions.load
import com.example.newsapp.R

class FavroiteAdapter(val Article:List<Model>): RecyclerView.Adapter<FavroiteAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val disc: TextView = itemView.findViewById<TextView>(R.id.disc)

        val headline: TextView = itemView.findViewById<TextView>(R.id.headline)
        val source = itemView.findViewById<TextView>(R.id.source)
        val fav:ImageView = itemView.findViewById(R.id.fav)
        val image = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavroiteAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.breakingnews, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FavroiteAdapter.ViewHolder, position: Int) {


        holder.disc.text = Article[position].discription
        val source = Article[position].Source
        holder.source.text = "Source:$source"
        holder.headline.text = Article[position].title
        holder.image.load(Article[position].repo_url)
        holder.fav.visibility = View.INVISIBLE

    }

    override fun getItemCount(): Int {
       return Article.size
    }
}