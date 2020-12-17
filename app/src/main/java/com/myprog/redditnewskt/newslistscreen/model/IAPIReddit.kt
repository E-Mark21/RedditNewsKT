package com.myprog.redditnewskt.newslistscreen.model

import com.myprog.redditnewskt.newslistscreen.model.pojo.RedditTopNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IAPIReddit {
    @GET("top.json")
    fun getNews(@Query("limit") limit :Int) : Call<RedditTopNews>
}