package com.example.newsapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.HeadLine.Article
import com.example.newsapp.Repo.ApiRepo
import kotlinx.coroutines.launch

class HeadLineViewModel:ViewModel() {
    val headlines = MutableLiveData<List<Article>>()
    val _headline : MutableLiveData<List<Article>> = headlines

     fun fatachHeadLines(apikey:String,country:String)  = viewModelScope.launch{
        ApiRepo.getHeadlines(apikey,country).body().let {
            _headline.postValue(it?.articles)
        }
    }
}