package com.example.newsapp.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Adapter.EveryThingAdapter
import com.example.newsapp.Adapter.HeadLineAdapter
import com.example.newsapp.R
import com.example.newsapp.ViewModel.FavroiteViewModel
import com.example.newsapp.ViewModel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment(),EveryThingAdapter.onClick {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var favViewModel: FavroiteViewModel
    private lateinit var viewModel:SearchViewModel
    private lateinit var Rv:RecyclerView
    private lateinit var adapter:EveryThingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        favViewModel = ViewModelProvider(this).get(FavroiteViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_search, container, false)
        Rv = view!!.findViewById(R.id.searchrecyclerview)
        adapter = EveryThingAdapter(this,favViewModel)
        Rv.adapter = adapter
        Rv.layoutManager = LinearLayoutManager(context)
            view.searchView.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                apiacall(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun apiacall(input:String){
        viewModel._search.observe(this, {
            if(it!=null)
            {
                adapter.Article = it
                adapter.notifyDataSetChanged()
            }
            else{

            }
        })
        viewModel.fatchEveryThing("fc44b959432d4237bef121343962c432",input)
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