package com.example.newsproject.data.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.newsproject.data.local.ArticleEntity
import com.example.newsproject.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article = intent.getParcelableExtra<ArticleEntity>("article")
        article?.let {
            binding.articleTitle.text = it.title
            binding.articleDescription.text = it.description
            binding.articleContent.text = it.content
            Glide.with(this)
                .load(it.urlToImage)
                .into(binding.articleImage)
        }
        binding.backButton.setOnClickListener{
            onBackPressed()
        }
    }
}
