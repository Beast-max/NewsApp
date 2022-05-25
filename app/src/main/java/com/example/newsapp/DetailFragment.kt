package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.newsapp.Extensions.load
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    private val args:DetailFragmentArgs by navArgs()
    private var content:String = ""
    private var imageUrl:String = ""
    private var title:String = ""
    private var src:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args.content?.let {
            content = it
        }
        args.title?.let {
            title = it
        }
        args.image?.let {
            imageUrl = it
        }
        args.source?.let {
            src = it
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_detail, container, false)
        view.findViewById<TextView>(R.id.headline).text = title
        view.findViewById<ImageView>(R.id.imageView).load(imageUrl)
        view.findViewById<TextView>(R.id.source).text = src
        view.findViewById<TextView>(R.id.disc).text = content
        return view
    }

}