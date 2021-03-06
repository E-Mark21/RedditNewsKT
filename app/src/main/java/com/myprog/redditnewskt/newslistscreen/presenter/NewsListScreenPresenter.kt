package com.myprog.redditnewskt.newslistscreen.presenter

import com.myprog.redditnewskt.newslistscreen.contract.MainContract
import com.myprog.redditnewskt.newslistscreen.model.NewsListScreenModel
import java.util.*
import kotlin.collections.ArrayList

lateinit var mModel: MainContract.Model
lateinit var timePublic: ArrayList<Int>

class NewsListScreenPresenter(view: MainContract.View) : MainContract.Presenter {

    private var mView = view

    init {
        mModel = NewsListScreenModel(this)
        mModel.loadNews()
    }

    override fun updateUI(
        author: ArrayList<String>,
        posted: ArrayList<Int>,
        num_comments: ArrayList<Int>,
        thumbnail: ArrayList<String>,
        url: ArrayList<String>,
        title: ArrayList<String>
    ) {
        for (i in 0..posted.size) {
            timePublic.add(getTimePublic(posted[i]))
        }
        mView.updateAdapter(author, timePublic, num_comments, thumbnail, url, title)
    }

    private fun getTimePublic(posted: Int): Int {
        val calendar = GregorianCalendar()
        val today = calendar.time
        val milSec = posted * 1000L
        val duration = today.time - milSec
        return (duration / (60 * 60 * 1000)).toInt()
    }
}