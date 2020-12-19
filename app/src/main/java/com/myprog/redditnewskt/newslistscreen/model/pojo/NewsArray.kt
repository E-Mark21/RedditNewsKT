package com.myprog.redditnewskt.newslistscreen.model.pojo

import com.fasterxml.jackson.annotation.JsonProperty

class NewsArray() {
    @JsonProperty("data")
    lateinit var news : News
}