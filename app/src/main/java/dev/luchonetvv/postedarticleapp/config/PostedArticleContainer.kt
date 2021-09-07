package dev.luchonetvv.postedarticleapp.config

import android.content.Context
import dev.luchonetvv.postedarticleapp.repository.ArticleRepository
import dev.luchonetvv.postedarticleapp.repository.network.SearchArticleApi
import dev.luchonetvv.postedarticleapp.screen.viewmodel.ArticleViewModelFactory

class PostedArticleContainer(context: Context) {
    private val postedArticleRetrofit = PostedArticleService.cteateService(SearchArticleApi::class.java)
    private val postedArticleDatabase = PostedArticleAppDatabase.getPostArticleAppDatabase(context, "posted_article_db")
    private val postedArticleRepository = ArticleRepository(postedArticleDatabase, postedArticleRetrofit)

    val articleViewModelFactory = ArticleViewModelFactory(postedArticleRepository)
}
