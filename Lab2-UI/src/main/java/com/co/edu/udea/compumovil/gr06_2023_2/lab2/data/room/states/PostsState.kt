package com.xcheko51x.crud_room_compose_kotlin.states

import com.co.edu.udea.compumovil.gr06_2023_2.lab2.data.room.PostEntity

data class PostsState(
    val postList: List<PostEntity> = emptyList()
)
