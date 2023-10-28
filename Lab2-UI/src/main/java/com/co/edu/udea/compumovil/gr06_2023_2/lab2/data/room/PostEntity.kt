package com.co.edu.udea.compumovil.gr06_2023_2.lab2.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_data")
data class PostEntity(
    val title: String,
    val subtitle: String,
    val url: String,
    @PrimaryKey()
    val id: String
)