package com.myprog.redditnewskt.newslistscreen.contract

interface MainContract {

    interface View {
        fun updateAdapter(
            author: ArrayList<String>,
            timePublic: ArrayList<Int>,
            num_comments: ArrayList<Int>,
            thumbnail: ArrayList<String>,
            url: ArrayList<String>,
            title: ArrayList<String>
        )
    }

    interface Presenter {
        fun updateUI(
            author: ArrayList<String>,
            posted: ArrayList<Int>,
            num_comments: ArrayList<Int>,
            thumbnail: ArrayList<String>,
            url: ArrayList<String>,
            title: ArrayList<String>
        )
    }

    interface Model {
        fun loadNews()
    }
}