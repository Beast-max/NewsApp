package com.example.newsapp.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.api.Everything.Article
import com.example.newsapp.Database.Model
import com.example.newsapp.Extensions.load
import com.example.newsapp.R
import com.example.newsapp.ViewModel.FavroiteViewModel

class EveryThingAdapter(val listner:onClick,val viewmodel:FavroiteViewModel): RecyclerView.Adapter<EveryThingAdapter.ViewHolder>()
   {
       var Article = ArrayList<Article>()
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val disc: TextView = itemView.findViewById<TextView>(R.id.disc)

        val headline: TextView = itemView.findViewById<TextView>(R.id.headline)
        val source = itemView.findViewById<TextView>(R.id.source)
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val fav = itemView.findViewById<ImageView>(R.id.fav)
        val root = itemView.findViewById<CardView>(R.id.root)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EveryThingAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.breakingnews,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EveryThingAdapter.ViewHolder, position: Int) {


        holder.disc.text = Article[position].description
        val source = Article[position].source.name
        holder.source.text = "Source:$source"
        holder.headline.text = Article[position].title
        holder.image.load(Article[position].urlToImage)
        holder.root.setOnClickListener {
            listner.inclick(Article[position].content,Article[position].title,Article[position].source.name,Article[position].urlToImage)
        }
        holder.fav.setOnClickListener {
            val data = Model(null,Article[position].source.name,Article[position].title,Article[position].description,Article[position].urlToImage)
            holder.fav.setImageResource(R.drawable.ic_baseline_favorite_24dw)
            viewmodel.insert(data)
            Article[position].clicked = true
        }
        if(Article[position].clicked )
        {
            holder.fav.setImageResource(R.drawable.ic_baseline_favorite_24dw)
        }
        else{
            holder.fav.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }

       override fun getItemCount(): Int {
           return Article.size
       }
interface onClick{
    fun inclick(content:String,title:String,source:String,image:String)
}
   }