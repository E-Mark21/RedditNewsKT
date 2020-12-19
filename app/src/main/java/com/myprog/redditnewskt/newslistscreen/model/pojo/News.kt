package com.myprog.redditnewskt.newslistscreen.model.pojo

import androidx.annotation.StringRes
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

class News() {

    @JsonProperty("author")
    lateinit var author: String
    @JsonProperty("thumbnail")
    lateinit var thumbnail: String
    @JsonProperty("url")
    lateinit var url: String
    @JsonProperty("title")
    lateinit var title: String
    @JsonProperty("created_utc")
    var created_utc: Int = 0
    @JsonProperty("num_comments")
    var num_comments: Int = 0


    @JsonIgnore
    val author_cakeday: String = ""
    @JsonIgnore
    val approved_at_utc: String = ""
    @JsonIgnore
    val subreddit: String = ""
    @JsonIgnore
    val selftext: String = ""
    @JsonIgnore
    val author_fullname: String = ""
    @JsonIgnore
    val saved: Boolean = false
    @JsonIgnore
    val mod_reason_title: String = ""
    @JsonIgnore
    val gilded: String = ""
    @JsonIgnore
    val clicked: Boolean = false
    @JsonIgnore
    val link_flair_richtext: List<String> = TODO()
    @JsonIgnore
    val subreddit_name_prefixed: String = ""
    @JsonIgnore
    val hidden: Boolean = false
    @JsonIgnore
    val pwls: Int
    @JsonIgnore
    val link_flair_css_class: String = ""
    @JsonIgnore
    val downs: Int
    @JsonIgnore
    val thumbnail_height: Int
    @JsonIgnore
    val top_awarded_type: String = ""
    @JsonIgnore
    val hide_score: Boolean = false
    @JsonIgnore
    val name: String = ""
    @JsonIgnore
    val quarantine: Boolean = false
    @JsonIgnore
    val link_flair_text_color: String
    @JsonIgnore
    val upvote_ratio: Double
    @JsonIgnore
    val author_flair_background_color: String = ""
    @JsonIgnore
    val subreddit_type: String = ""
    @JsonIgnore
    val ups: Int
    @JsonIgnore
    val total_awards_received: Int
    @JsonIgnore
    val thumbnail_width: Int
    @JsonIgnore
    val author_flair_template_id: String = ""
    @JsonIgnore
    val is_original_content: Boolean = false
    @JsonIgnore
    val user_reports: List<String> = TODO()
    @JsonIgnore
    val secureMedia: SecureMedia
    @JsonIgnore
    val is_reddit_media_domain: Boolean = false
    @JsonIgnore
    val is_meta: Boolean = false
    @JsonIgnore
    val category: String = ""
    @JsonIgnore
    val secure_media_embed: SecureMediaEmbed
    @JsonIgnore
    val link_flair_text: String
    @JsonIgnore
    val can_mod_post: Boolean = false
    @JsonIgnore
    val score: Int
    @JsonIgnore
    val approved_by: String = ""
    @JsonIgnore
    val author_premium: Boolean = false
    @JsonIgnore
    val edited: Boolean = false
    @JsonIgnore
    val author_flair_css_class: String= ""
    @JsonIgnore
    val author_flair_richtext: List<String>
    @JsonIgnore
    val gildings: Gildings
    @JsonIgnore
    val post_hint: String = ""
    @JsonIgnore
    val content_categories: String = ""
    @JsonIgnore
    val is_self: Boolean = false
    @JsonIgnore
    val mod_note: String = ""
    @JsonIgnore
    val created: Long
    @JsonIgnore
    val link_flair_type: String = ""
    @JsonIgnore
    val wls: Int
    @JsonIgnore
    val removed_by_category: String = ""
    @JsonIgnore
    val banned_by: String = ""
    @JsonIgnore
    val author_flair_type: String = ""
    @JsonIgnore
    val domain: String = ""
    @JsonIgnore
    val allow_live_comments: String = ""
    @JsonIgnore
    val selftext_html: String = ""
    @JsonIgnore
    val likes: String = ""
    @JsonIgnore
    val suggested_sort: String = ""
    @JsonIgnore
    val banned_at_utc: String = ""
    @JsonIgnore
    val url_overridden_by_dest: String = ""
    @JsonIgnore
    val view_count: String = ""
    @JsonIgnore
    val archived: String = ""
    @JsonIgnore
    val no_follow: String = ""
    @JsonIgnore
    val is_crosspostable: String = ""
    @JsonIgnore
    val pinned: String = ""
    @JsonIgnore
    val over_18: String = ""
    @JsonIgnore
    val preview: Preview
    @JsonIgnore
    val all_awardings: AllAwardings
    @JsonIgnore
    val awarders: List<Avarders>
    @JsonIgnore
    val media_only: String = ""
    @JsonIgnore
    val can_gild: String = ""
    @JsonIgnore
    val spoiler: String = ""
    @JsonIgnore
    val locked: String = ""
    @JsonIgnore
    val author_flair_text: String = ""
    @JsonIgnore
    val treatment_tags: TreatmentsTags
    @JsonIgnore
    val visited: Boolean = false
    @JsonIgnore
    val removed_by: String = ""
    @JsonIgnore
    val num_reports: String = ""
    @JsonIgnore
    val distinguished: String = ""
    @JsonIgnore
    val subreddit_id: String = ""
    @JsonIgnore
    val mod_reason_by: String = ""
    @JsonIgnore
    val removal_reason: String = ""
    @JsonIgnore
    val link_flair_background_color: String = ""
    @JsonIgnore
    val id: String = ""
    @JsonIgnore
    val is_robot_indexable: String = ""
    @JsonIgnore
    val report_reasons: String = ""
    @JsonIgnore
    val discussion_type: String = ""
    @JsonIgnore
    val send_replies: Boolean = false
    @JsonIgnore
    val whitelist_status: String = ""
    @JsonIgnore
    val contest_mode: String = ""
    @JsonIgnore
    val mod_reports: List<ModReports>
    @JsonIgnore
    val author_patreon_flair: Boolean = false
    @JsonIgnore
    val author_flair_text_color: String = ""
    @JsonIgnore
    val permalink: String = ""
    @JsonIgnore
    val parent_whitelist_status: String = ""
    @JsonIgnore
    val stickied: Boolean = false
    @JsonIgnore
    val subreddit_subscribers: String = ""
    @JsonIgnore
    val num_crossposts: String = ""
    @JsonIgnore
    val media: String = ""
    @JsonIgnore
    val is_video: Boolean = false
    @JsonIgnore
    val media_embed: MediaEmbed
    @JsonIgnore
    val secure_media: String = ""
    @JsonIgnore
    val link_flair_template_id: String = ""

}