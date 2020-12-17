package com.myprog.redditnewskt.newslistscreen.model

import com.fasterxml.jackson.databind.ObjectMapper
import com.myprog.redditnewskt.newslistscreen.contract.MainContract
import com.myprog.redditnewskt.newslistscreen.model.pojo.Data
import com.myprog.redditnewskt.newslistscreen.model.pojo.NewsArray
import com.myprog.redditnewskt.newslistscreen.model.pojo.RedditTopNews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

private const val numberOfNews = 50
private const val BASE_URL = "https://www.reddit.com/"

class NewsListScreenModel : MainContract.Model {

    private val mObjectMapper = ObjectMapper()
    private val mRetrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory
            .create(mObjectMapper))
            .build()
    private val mIAPIReddit: IAPIReddit = mRetrofit.create(IAPIReddit::class.java)

    override fun loadNews() {
        val call = mIAPIReddit.getNews(numberOfNews).enqueue(object : Callback<RedditTopNews> {
            override fun onResponse(call: Call<RedditTopNews>, response: Response<RedditTopNews>) {
                val redditTopNews : RedditTopNews? = response.body()
                val topNewsFromReddit : Data = redditTopNews?.data ?: Data()
                val newsArrayList = listOf(topNewsFromReddit.newsArray)
                for (i in 0..newsArrayList.size) {

                }

            }

            override fun onFailure(call: Call<RedditTopNews>, t: Throwable) {

            }
        })
    }
}