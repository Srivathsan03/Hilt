package com.sri.hiltapplication.di

import android.content.Context
import androidx.room.Room
import com.sri.hiltapplication.newDB.AppDatabase
import com.sri.hiltapplication.newDB.ChannelDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

 /*   @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext application: Application) = UserDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideDao(database: UserDatabase) = database.usersDao()*/


    @Provides
    fun provideChannelDao(appDatabase: AppDatabase): ChannelDao {
        return appDatabase.channelDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "RssReader"
        ).build()
    }


}