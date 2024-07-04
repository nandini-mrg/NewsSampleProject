package com.example.newsproject.di



import android.content.Context
import androidx.room.Room
import com.example.newsproject.data.local.AppDatabase
import com.example.newsproject.data.local.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "articles.db"
        ).build()
    }

    @Provides
    fun provideArticleDao(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.articleDao()
    }
}

