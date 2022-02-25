package com.sri.hiltapplication.ui

import com.sri.hiltapplication.data.User
import com.sri.hiltapplication.newDB.ChannelDao
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class MainRepository @Inject constructor(private val userDao: ChannelDao) {

    suspend fun insert(user: User) {
        CoroutineScope(Dispatchers.Default).launch {
            userDao.insert(user)
        }
    }

    suspend fun getAllUser(): List<User> {
        return CoroutineScope(Dispatchers.Default).async {
            return@async userDao.getAllUsers()
        }.await()
    }
}