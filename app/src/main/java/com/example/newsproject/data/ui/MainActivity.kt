package com.example.newsproject.data.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsAdapter = NewsAdapter { article ->
            val intent = Intent(this, ArticleActivity::class.java).apply {
                putExtra("article", article)
            }
            startActivity(intent)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }

        viewModel.news.observe(this, Observer { articles ->
            newsAdapter.submitList(articles)
        })

        viewModel.fetchNews()
    }
}
