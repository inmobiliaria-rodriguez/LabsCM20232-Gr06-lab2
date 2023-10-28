package com.co.edu.udea.compumovil.gr06_2023_2.lab2.data.room

import kotlinx.coroutines.flow.Flow


class PostDataRepository (private val postDao: PostDao){

    val readAllData: Flow<List<PostEntity>> = postDao.readAllData()

    suspend fun addPost(postEntity: PostEntity){
        postDao.addPost(postEntity)
    }

}