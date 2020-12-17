package com.myprog.redditnewskt.newslistscreen.model.pojo

import com.fasterxml.jackson.annotation.JsonProperty

class NewsArray {
    @JsonProperty("data")
    var news : News? = null
        get() {return news}
}