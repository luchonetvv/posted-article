package dev.luchonetvv.postedarticleapp.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import dev.luchonetvv.postedarticleapp.domain.entity.ArticleEntity

@Dao
interface ArticleDao {
    @Query("SELECT * FROM ArticleEntity")
    fun getAll(): LiveData<List<ArticleEntity>>

    @Delete fun deleteById(article: ArticleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<ArticleEntity>)
}
