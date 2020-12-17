package com.myprog.redditnewskt.newslistscreen.model.pojo

import com.fasterxml.jackson.annotation.JsonProperty

class Data {

    @JsonProperty("children")
    var newsArray : List<NewsArray>? = null


}