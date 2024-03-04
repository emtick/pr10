package com.example.myapplication222.repository

import androidx.lifecycle.LiveData
import com.example.myapplication222.Post
interface PostRepository {
    fun getAll(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun save(post: Post)
    fun removeById(id: Long)
    fun shar(id: Long)
}