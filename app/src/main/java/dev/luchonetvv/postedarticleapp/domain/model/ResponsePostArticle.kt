package dev.luchonetvv.postedarticleapp.domain.model

import com.google.gson.annotations.SerializedName

data class ResponsePostArticle(
    @SerializedName("hits")
    val hits: List<Article>
)
