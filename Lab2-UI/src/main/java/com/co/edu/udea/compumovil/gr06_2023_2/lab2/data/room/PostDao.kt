package com.co.edu.udea.compumovil.gr06_2023_2.lab2.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(postEntity: PostEntity)

    @Query("SELECT * FROM post_data")
    fun readAllData(): Flow<List<PostEntity>>

}