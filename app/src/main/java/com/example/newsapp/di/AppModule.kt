package com.example.newsapp.di

import android.app.Application
import androidx.room.Dao
import androidx.room.Room
import com.example.newsapp.data.LocalUserManagerImpl
import com.example.newsapp.data.local.NewsDB
import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.data.local.NewsTypeConvertor
import com.example.newsapp.data.remote.dto.NewsApi
import com.example.newsapp.data.repoimpl.NewsRepoImpl
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.domain.repository.NewsRepo
import com.example.newsapp.domain.usecases.news.DeleteArticles
import com.example.newsapp.domain.usecases.news.GetNews
import com.example.newsapp.domain.usecases.news.NewsUsesCases
import com.example.newsapp.domain.usecases.news.SearchNews
import com.example.newsapp.domain.usecases.news.SelectArticle2
import com.example.newsapp.domain.usecases.news.SelectArticles
import com.example.newsapp.domain.usecases.news.UpsertArticles
import com.example.newsapp.domain.usecases.saveread.read.ReadAppEntry
import com.example.newsapp.domain.usecases.saveread.AppEntryUseCases
import com.example.newsapp.domain.usecases.saveread.save.SaveAppEntry
import com.example.newsapp.utils.Constance.BASE_URL
import com.example.newsapp.utils.Constance.NEWS_DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun providesNewsApi() : NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepo(newsApi: NewsApi, newsDao: NewsDao): NewsRepo = NewsRepoImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepo: NewsRepo):NewsUsesCases{
        return NewsUsesCases(
            GetNews(newsRepo),
            SearchNews(newsRepo),
            UpsertArticles(newsRepo),
            SelectArticles(newsRepo),
            DeleteArticles(newsRepo),
            SelectArticle2(newsRepo)
        )
    }


    @Provides
    @Singleton
    fun providesNewsDataBase(application: Application): NewsDB{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDB::class.java,
            name = NEWS_DATA_BASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDTO(newsDatabase: NewsDB): NewsDao = newsDatabase.newsDao

}