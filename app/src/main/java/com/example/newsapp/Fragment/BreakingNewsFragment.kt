package com.example.newsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Adapter.EveryThingAdapter
import com.example.newsapp.Adapter.HeadLineAdapter
import com.example.newsapp.R
import com.example.newsapp.ViewModel.FavroiteViewModel
import com.example.newsapp.ViewModel.HeadLineViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BreakingNewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BreakingNewsFragment : Fragment(),HeadLineAdapter.onClick {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewmodel:HeadLineViewModel
    private lateinit var Rv:RecyclerView
    private lateinit var adapter:HeadLineAdapter
    private lateinit var favViewModel:FavroiteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_breaking_news, container, false)
        viewmodel = ViewModelProvider(this).get(HeadLineViewModel::class.java)
        favViewModel = ViewModelProvider(this).get(FavroiteViewModel::class.java)
        Rv = view!!.findViewById(R.id.breaking)

        adapter = HeadLineAdapter(this,favViewModel)
        Rv.adapter = adapter
        Rv.layoutManager = LinearLayoutManager(context)
        viewmodel.headlines.observe({lifecycle}){
            adapter.submitList(it)
        }
        viewmodel.fatachHeadLines("fc44b959432d4237bef121343962c432","us")
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BreakingNewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BreakingNewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun inclick(content: String, title: String, source: String, image: String) {
        findNavController().navigate(R.id.action_hots_to_discription,Bundle().apply {
            putString("content",content)
            putString("title",title)
            putString("source",source)
            putString("image",image)
        })
    }
}