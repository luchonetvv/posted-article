package dev.luchonetvv.postedarticleapp.screen.viewmodel

import dev.luchonetvv.postedarticleapp.repository.ArticleRepository

interface ViewModelFactory<T> {
    fun create(): T
}

class ArticleViewModelFactory(private val articleRepository: ArticleRepository) : ViewModelFactory<ArticleViewModel> {
    override fun create(): ArticleViewModel {
        return ArticleViewModel(articleRepository)
    }
}
