package com.myprog.redditnewskt.newslistscreen.model.pojo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

class Data() {
    @JsonProperty("children")
    lateinit var newsArray : ArrayList<NewsArray>
    @JsonIgnore
    lateinit var modhash: String
    @JsonIgnore
    var dist: Int = 0
    @JsonIgnore
    lateinit var after: String
    @JsonIgnore
    lateinit var before: String
}