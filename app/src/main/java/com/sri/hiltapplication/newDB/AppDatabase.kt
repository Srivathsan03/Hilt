package com.sri.hiltapplication.newDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sri.hiltapplication.data.User


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun channelDao(): ChannelDao
}