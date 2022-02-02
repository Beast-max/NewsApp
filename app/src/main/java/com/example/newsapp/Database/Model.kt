package com.example.newsapp.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RepoData_table")
data class Model(
    @PrimaryKey(autoGenerate = true)
    val repoid: Int?,

    @ColumnInfo(name= "Source")
    var Source:String="",

    @ColumnInfo(name = "title")
    var title:String="",

    @ColumnInfo(name = "discription")
    var discription:String?="",

    @ColumnInfo(name = "Repo_Url")
    var repo_url:String,
)