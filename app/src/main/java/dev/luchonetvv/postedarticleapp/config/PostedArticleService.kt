package dev.luchonetvv.postedarticleapp.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface PostedArticleService {

    companion object {
        const val URL_BASE = "https://hn.algolia.com/api/v1/"

        const val RESOURCE_SEARCH_BY_DATE = "search_by_date?query=mobile"

        fun <S> cteateService(serviceClass: Class<S>?): S {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL_BASE)
                .build()
                .create(serviceClass!!)
        }
    }

}
