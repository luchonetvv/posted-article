package dev.luchonetvv.postedarticleapp.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import dev.luchonetvv.postedarticleapp.config.PostedArticleAppDatabase
import dev.luchonetvv.postedarticleapp.domain.entity.ArticleEntity
import dev.luchonetvv.postedarticleapp.domain.model.ResponsePostArticle
import dev.luchonetvv.postedarticleapp.repository.network.SearchArticleApi
import dev.luchonetvv.postedarticleapp.screen.SwipeCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger

class ArticleRepository(
    private val postedArticleDatabase: PostedArticleAppDatabase,
    private val postedArticleApi: SearchArticleApi
) {
    fun getAll(): LiveData<List<ArticleEntity>> = postedArticleDatabase.articleDao().getAll()

    fun deleteItem(articleEntity: ArticleEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            postedArticleDatabase.articleDao().deleteById(articleEntity)
        }
    }

    fun getArticleRemoteAndPersistIt(swipeCallback: SwipeCallback) {
        postedArticleApi.getArticleByDate().enqueue(object : Callback<ResponsePostArticle> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(
                call: Call<ResponsePostArticle>,
                response: Response<ResponsePostArticle>
            ) {
                if (response.body() != null) {
                    GlobalScope.launch(Dispatchers.IO) {
                        postedArticleDatabase.articleDao().insertAll(
                            response.body()!!.hits.map {
                                val title = it.storyTitle ?: it.title
                                val url = it.storyUrl ?: it.url
                                ArticleEntity(
                                    it.createdAtI,
                                    it.storyId,
                                    title ?: "NOTITLE",
                                    url ?: "NOTURL",
                                    it.author,
                                    it.createdAt
                                )
                            }
                        )
                    }
                }
            }

            override fun onFailure(call: Call<ResponsePostArticle>, t: Throwable) {
                Logger.getLogger(ArticleRepository::class.java.simpleName)
                    .log(Level.SEVERE, "ERROR: Response unsatisfied", t)
                swipeCallback()
            }

        })
    }
}
