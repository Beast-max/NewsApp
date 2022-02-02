package com.example.newsapp.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(Repo: Model)

    @Query("SELECT * from RepoData_table ORDER by repoid DESC")
    fun getAllRepo(): LiveData<List<Model>>

    @Query("DELETE from RepoData_table")
    fun clear()

    @Query("SELECT * from RepoData_table")
    fun geturl():List<Model>




}