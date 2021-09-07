package dev.luchonetvv.postedarticleapp.domain.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("created_at_i")
    var createdAtI: Long,
    @SerializedName("story_id")
    var storyId: Long,
    @SerializedName("title")
    var title: String?,
    @SerializedName("story_title")
    var storyTitle: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("story_url")
    var storyUrl: String?,
    @SerializedName("author")
    var author: String,
    @SerializedName("created_at")
    var createdAt: String
)
