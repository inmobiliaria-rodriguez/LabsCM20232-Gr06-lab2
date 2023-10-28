package com.co.edu.udea.compumovil.gr06_2023_2.lab2.data.room

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.xcheko51x.crud_room_compose_kotlin.states.PostsState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PostViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PostDataRepository
    var state by mutableStateOf(PostsState())
        private set

    init {
        val postDao = PostDataBase.getDataBase(application).postDao()
        repository = PostDataRepository(postDao)
        viewModelScope.launch {
            postDao.readAllData().collectLatest {
                state = state.copy(
                    postList = it
                )
            }
        }
    }

    fun addPost(postEntity: PostEntity){
        viewModelScope.launch() {
            repository.addPost(postEntity)
        }
    }

}