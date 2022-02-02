package com.example.newsapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.api.HeadLine.Article
import com.example.newsapp.Database.Model
import com.example.newsapp.Extensions.load
import com.example.newsapp.R
import com.example.newsapp.ViewModel.FavroiteViewModel

class HeadLineAdapter(val viewmodel:FavroiteViewModel): ListAdapter<Article, HeadLineAdapter.ViewHolder>(object :DiffUtil.ItemCallback<Article>(){
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
       return  oldItem.toString() ==newItem.toString()
    }

}) {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val disc = itemView.findViewById<TextView>(R.id.disc)

        val headline = itemView.findViewById<TextView>(R.id.headline)
        val source = itemView.findViewById<TextView>(R.id.source)
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val fav = itemView.findViewById<ImageView>(R.id.fav)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadLineAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.breakingnews,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HeadLineAdapter.ViewHolder, position: Int) {
        val article = getItem(position)

        holder.disc.text = article.description
        val source = article.source.name
        holder.source.text = "Source:$source"
        holder.headline.text = article.title
        holder.image.load(article.urlToImage)
        holder.fav.setOnClickListener {
            val data = Model(null,article.source.name,article.title,article.description,article.urlToImage)
            holder.fav.setImageResource(R.drawable.ic_baseline_favorite_24dw)
            viewmodel.insert(data)
        }

    }


}