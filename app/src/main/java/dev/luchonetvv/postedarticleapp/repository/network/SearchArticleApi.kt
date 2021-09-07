package dev.luchonetvv.postedarticleapp.repository.network

import dev.luchonetvv.postedarticleapp.config.PostedArticleService
import dev.luchonetvv.postedarticleapp.domain.model.ResponsePostArticle
import retrofit2.Call
import retrofit2.http.GET

interface SearchArticleApi {

    @GET(PostedArticleService.URL_BASE + PostedArticleService.RESOURCE_SEARCH_BY_DATE)
    fun getArticleByDate(): Call<ResponsePostArticle>

}
