package dev.luchonetvv.postedarticleapp.screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.luchonetvv.postedarticleapp.domain.entity.ArticleEntity
import dev.luchonetvv.postedarticleapp.repository.ArticleRepository
import dev.luchonetvv.postedarticleapp.screen.SwipeCallback

class ArticleViewModel(private val articleRepository: ArticleRepository) : ViewModel() {
    var allArticles: LiveData<List<ArticleEntity>> = articleRepository.getAll()

    fun requestArticleAndPersistIt(swipeCallback: SwipeCallback) = articleRepository.getArticleRemoteAndPersistIt(swipeCallback)

    fun deleteItem(articleEntity: ArticleEntity) = articleRepository.deleteItem(articleEntity)
}
