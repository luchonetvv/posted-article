package dev.luchonetvv.postedarticleapp.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
    @PrimaryKey @ColumnInfo(name = "created_at_i") val createdAtI: Long,
    @ColumnInfo(name = "story_id") val storyId: Long,
    @ColumnInfo(name = "story_title") val storyTitle: String,
    @ColumnInfo(name = "story_url") val storyUrl: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "created_at") val createdAt: String
)
