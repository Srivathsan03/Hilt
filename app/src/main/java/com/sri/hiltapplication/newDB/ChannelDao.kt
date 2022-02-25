package com.sri.hiltapplication.newDB

import androidx.room.*
import com.sri.hiltapplication.data.User

@Dao
interface ChannelDao {

    @Insert
    fun insert(user: User)

    @Query("select * from user_table")
    fun getAllUsers():List<User>

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}