package com.myprog.redditnewskt.newslistscreen.model.pojo

import com.fasterxml.jackson.annotation.JsonProperty

class RedditTopNews {
    @JsonProperty("data")
    var data: Data = TODO()
        get() {return data}
}