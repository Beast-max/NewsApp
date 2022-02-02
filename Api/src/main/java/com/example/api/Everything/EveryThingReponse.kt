package com.example.api.Everything


import com.google.gson.annotations.SerializedName

data class EveryThingReponse(
    @SerializedName("articles")
    val articles: ArrayList<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)