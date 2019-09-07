package com.andalus.abomedhat.mvvm.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andalus.abomedhat.mvvm.utils.Constants

@Entity
data class User(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = Constants.COLUMN_NAME) val name: String,
    @ColumnInfo(name = Constants.COLUMN_PHONE) val phone: String,
    @ColumnInfo(name = Constants.COLUMN_EMAIL) val email: String
)