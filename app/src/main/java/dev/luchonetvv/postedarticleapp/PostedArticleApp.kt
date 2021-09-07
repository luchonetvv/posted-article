package dev.luchonetvv.postedarticleapp

import android.app.Application
import dev.luchonetvv.postedarticleapp.config.PostedArticleContainer

class PostedArticleApp : Application() {
    lateinit var postArticleContainer: PostedArticleContainer

    override fun onCreate() {
        super.onCreate()
        postArticleContainer = PostedArticleContainer(this)
    }
}
