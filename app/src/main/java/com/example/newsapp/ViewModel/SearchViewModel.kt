package com.example.newsapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.Everything.Article
import com.example.api.Everything.EveryThingReponse
import com.example.newsapp.Repo.ApiRepo
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class SearchViewModel:ViewModel() {
    val search = MutableLiveData<ArrayList<Article>?>()
    val _search: MutableLiveData<ArrayList<Article>?> = search

     fun fatchEveryThing(apiKey:String,topic:String){
        ApiRepo.getSearch(apiKey,topic)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getArticleObserver())
    }
    private fun getArticleObserver():Observer<EveryThingReponse> {
        return object :Observer<EveryThingReponse>{
            override fun onComplete() {
                //hide progress indicator .
            }

            override fun onError(e: Throwable) {
                _search.postValue(null)
            }

            override fun onNext(t: EveryThingReponse) {
                _search.postValue(t.articles)
            }

            override fun onSubscribe(d: Disposable) {
                //start showing progress indicator.
            }
        }
    }

}