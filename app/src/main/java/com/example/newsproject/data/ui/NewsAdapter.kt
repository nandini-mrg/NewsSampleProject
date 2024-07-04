package com.example.newsproject.data.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsproject.R
import com.example.newsproject.data.local.ArticleEntity
import com.example.newsproject.data.util.TimeUtils

class NewsAdapter(private val onItemClicked: (ArticleEntity) -> Unit) :
    ListAdapter<ArticleEntity, RecyclerView.ViewHolder>(DiffCallback) {

    companion object {
        private const val VIEW_TYPE_FIRST = 0
        private const val VIEW_TYPE_OTHER = 1

        private val DiffCallback = object : DiffUtil.ItemCallback<ArticleEntity>() {
            override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_FIRST else VIEW_TYPE_OTHER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_FIRST) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_article_first, parent, false)
            FirstArticleViewHolder(view, onItemClicked)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_article, parent, false)
            OtherArticleViewHolder(view, onItemClicked)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = getItem(position)
        val timeDifference = TimeUtils.getTimeDifference(article.publishedAt)

        if (holder is FirstArticleViewHolder) {
            holder.bind(article,timeDifference)
        } else if (holder is OtherArticleViewHolder) {
            holder.bind(article,timeDifference)
        }
    }

    class FirstArticleViewHolder(itemView: View, private val onItemClicked: (ArticleEntity) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.articleImage)
        private val titleView: TextView = itemView.findViewById(R.id.articleTitle)
        private val descriptionView: TextView = itemView.findViewById(R.id.articleDescription)
        private val articleTime: TextView = itemView.findViewById(R.id.articleTime)

        fun bind(article: ArticleEntity, timeDifference:String) {
            titleView.text = article.title
            descriptionView.text = article.description
            articleTime.text = timeDifference

            Glide.with(imageView.context)
                .load(article.urlToImage)
                .into(imageView)
            itemView.setOnClickListener { onItemClicked(article) }
        }
    }

    class OtherArticleViewHolder(itemView: View, private val onItemClicked: (ArticleEntity) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.articleImage)
        private val titleView: TextView = itemView.findViewById(R.id.articleTitle)
        private val descriptionView: TextView = itemView.findViewById(R.id.articleDescription)
        private val articleTime: TextView = itemView.findViewById(R.id.articleTime)

        fun bind(article: ArticleEntity, timeDifference:String) {
            titleView.text = article.title
            descriptionView.text = article.description
            Glide.with(imageView.context)
                .load(article.urlToImage)
                .error(R.mipmap.icon)
                .into(imageView)
            itemView.setOnClickListener { onItemClicked(article) }
            articleTime.text = timeDifference
        }
    }
}
