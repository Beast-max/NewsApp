package com.example.api.HeadLine


import com.google.gson.annotations.SerializedName

data class HeadLineReponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)