package com.example.newsapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.Database.Model
import com.example.newsapp.Database.RoomDB
import kotlinx.coroutines.*

class FavroiteViewModel(application: Application): AndroidViewModel(application) {

    private val db:RoomDB = RoomDB.getinstanc(application)
    internal val getallrepo: LiveData<List<Model>> =db.RepoDatabaseDao().getAllRepo()

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _showSnackbarEvent = MutableLiveData<Boolean?>()
    val showSnackBarEvent: LiveData<Boolean?>
        get() = _showSnackbarEvent

    fun insert(repoData: Model){
        uiScope.launch {
            withContext(Dispatchers.IO) {
                db.RepoDatabaseDao().insert(repoData)
            }
        }

    }

    fun onClear() {
        uiScope.launch {
            withContext(Dispatchers.IO) {

                db.RepoDatabaseDao().clear()
            }

            _showSnackbarEvent.value = true
        }
    }
    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}