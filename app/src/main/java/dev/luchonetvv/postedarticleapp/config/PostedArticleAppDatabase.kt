package dev.luchonetvv.postedarticleapp.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.luchonetvv.postedarticleapp.domain.entity.ArticleEntity
import dev.luchonetvv.postedarticleapp.repository.dao.ArticleDao

@Database(entities = [ArticleEntity::class], version = 1)
abstract class PostedArticleAppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: PostedArticleAppDatabase? = null

        fun getPostArticleAppDatabase(
            context: Context,
            databaseName: String
        ): PostedArticleAppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    PostedArticleAppDatabase::class.java,
                    databaseName
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
