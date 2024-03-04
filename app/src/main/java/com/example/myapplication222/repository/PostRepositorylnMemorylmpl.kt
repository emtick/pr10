package com.example.myapplication222.repository
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication222.Post
class PostRepositorylnMemorylmpl ( application: Application) : PostRepository {
    private var nextId = 1L
    private var posts = listOf(
        Post(
            id = nextId++,
            author = "Chreks",
            content = "Привет! Я — голосовой помощник, который может придумать для вас текст на любую тему. Просто задайте мне тему, и я создам для вас уникальный текст.",
            published = "28 февраля в 10:00",
            likedByMe = false,
            likes = 234,
            shares = 112,
            vieeew = 623
        ),
        Post(
            id = nextId++,
            author = "Chreks",
            content = "Привет! Я — голосовой помощник, который может придумать для вас текст на любую тему. Просто задайте мне тему, и я создам для вас уникальный текст.",
            published = "27 февраля в 10:00",
            likedByMe = false,
            likes = 342,
            shares = 132,
            vieeew = 453
        ),
        Post(
            id = nextId++,
            author = "Chreks",
            content = "Привет! Я — голосовой помощник, который может придумать для вас текст на любую тему. Просто задайте мне тему, и я создам для вас уникальный текст.",
            published = "26 февраля в 10:00",
            likedByMe = false,
            likes = 135,
            shares = 12,
            vieeew = 344
        ),
    )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data
    override fun save(post: Post) {
        if (post.id == 0L) {
            posts = listOf(
                post.copy(
                    id = nextId++,
                    author = "Me",
                    likedByMe = false,
                    published = "now"
                )
            ) + posts
            data.value = posts
            return
        }

        posts = posts.map {
            if (it.id != post.id) it else it.copy(content = post.content)
        }
        data.value = posts
    }

    override fun likeById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(
                likedByMe = !it.likedByMe,
                likes = if (it.likedByMe) it.likes - 1 else it.likes + 1,
            )
        }
        data.value = posts
    }

    override fun shar(id: Long) {
        posts =posts.map {
            if (it.id != id) it else it.copy(
                shares = it.shares +1
            )
        }
        data.value = posts
    }

    override fun removeById(id: Long) {
        posts = posts.filter { it.id != id }
        data.value = posts
    }

}