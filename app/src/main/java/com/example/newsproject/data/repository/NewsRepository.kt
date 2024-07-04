package com.example.newsproject.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsproject.data.local.ArticleDao
import com.example.newsproject.data.local.ArticleEntity
import com.example.newsproject.data.remote.NewsApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService,
    private val articleDao: ArticleDao
) {
    val articles: LiveData<List<ArticleEntity>> = articleDao.getAllArticles()

    suspend fun refreshArticles() {
        val response = newsApiService.getTopHeadlines("f71af7261c434b5d8be60816ed910d8b")
        articleDao.deleteAllArticles()
        articleDao.insertAll(response.articles.map {
            ArticleEntity(
                id = 0,
                title = it.title,
                description = it.description,
                content  = it.url,
                urlToImage = it.urlToImage,
                publishedAt = it.publishedAt
            )
        })
    }
}
