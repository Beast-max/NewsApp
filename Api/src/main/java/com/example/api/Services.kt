package com.example.api

import com.example.api.Everything.EveryThingReponse
import com.example.api.HeadLine.HeadLineReponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {
    @GET("top-headlines")
   suspend  fun getheadline(@Query("apiKey")apiKey:String,@Query("country")country:String): Response<HeadLineReponse>

    @GET("everything")
     fun getEveryThing(@Query("apiKey")apiKey:String,@Query("q")q:String):Observable<EveryThingReponse>

}