package com.myprog.redditnewskt.newslistscreen.model.pojo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

class RedditTopNews() {

    @JsonIgnore
    lateinit var kind: String
    @JsonProperty("data")
    lateinit var data: Data
    
}