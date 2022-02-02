package com.example.newsapp.Repo

import com.example.api.ApiClient

object ApiRepo {
    suspend fun getHeadlines(apiKey:String,country:String) = ApiClient.api.getheadline(apiKey,country)
     fun getSearch(apiKey: String,topic:String) = ApiClient.api.getEveryThing(apiKey,topic)
}