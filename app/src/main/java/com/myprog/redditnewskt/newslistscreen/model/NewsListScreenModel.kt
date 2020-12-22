package com.myprog.redditnewskt.newslistscreen.model

import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.myprog.redditnewskt.newslistscreen.contract.MainContract
import com.myprog.redditnewskt.newslistscreen.model.pojo.RedditTopNews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

private const val numberOfNews = 50
private const val BASE_URL = "https://www.reddit.com/"
private const val TAG = "Model"

class NewsListScreenModel(presenter : MainContract.Presenter) : MainContract.Model {

    lateinit var author: ArrayList<String>
    lateinit var thumbnail: ArrayList<String>
    lateinit var url: ArrayList<String>
    lateinit var title: ArrayList<String>
    lateinit var posted: ArrayList<Int>
    lateinit var num_comments: ArrayList<Int>


    var mPresenter = presenter

    private val mObjectMapper = ObjectMapper()
    private val mRetrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory
            .create(mObjectMapper))
            .build()
    private var mIAPIReddit: IAPIReddit = mRetrofit.create(IAPIReddit::class.java)

    override fun loadNews() {
        Log.d(TAG, "Started")
        val call: Call<RedditTopNews> =  mIAPIReddit.getNews(numberOfNews)
            call.enqueue(object : Callback<RedditTopNews> {
            override fun onResponse(call: Call<RedditTopNews>, response: Response<RedditTopNews>) {
                val redditTopNews = response.body()
                val topNewsFromReddit = redditTopNews?.data     //Data
                val newsArrayList = topNewsFromReddit?.newsArray
                if (newsArrayList != null) {
                    for (i in 0..newsArrayList.size) {
                        val newsArray = newsArrayList[i]
                        val news = newsArray.news
                        author.add(news.author)
                        thumbnail.add(news.thumbnail)
                        url.add(news.url)
                        title.add(news.title)
                        posted.add(news.created_utc)
                        num_comments.add(news.num_comments)
                    }
                   // mPresenter.updateUI(author, posted, num_comments, thumbnail, url, title)
                }
            }

            override fun onFailure(call: Call<RedditTopNews>, t: Throwable) {

                val s : String = t.toString()
                val d = 5
            }
        })
    }
}