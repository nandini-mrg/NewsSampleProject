package com.example.newsproject.data.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsproject.data.local.ArticleEntity
import com.example.newsproject.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _news = MutableLiveData<List<ArticleEntity>>()
    val news: LiveData<List<ArticleEntity>> get() = repository.articles

    fun fetchNews() {
        viewModelScope.launch {
            repository.refreshArticles()
        }
    }
}
