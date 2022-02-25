package com.sri.hiltapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId: Int? = null,
    val userName: String,
    var location: String,
    var email: String
)