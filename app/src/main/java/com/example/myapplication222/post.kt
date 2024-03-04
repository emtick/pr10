package com.example.myapplication222

 data class Post (
     val id: Long,
     val author: String,
     val content: String,
     val published: String,
     val likedByMe: Boolean,
     val likes: Int = 0,
     val shares: Int =0,
     val vieeew: Int =0

  )