package com.example.newsproject.data.local


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String?,
    val content: String?,
    val urlToImage: String?,
    val publishedAt: String
) : Parcelable
