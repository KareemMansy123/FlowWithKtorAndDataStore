package com.mansy.datastorewithktor.data.remote.view_modes

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.mansy.datastorewithktor.core.flow.BaseViewModel
import com.mansy.datastorewithktor.core.flow.Resource
import com.mansy.datastorewithktor.data.remote.entites.PostEntityItem
import com.mansy.datastorewithktor.data.repos.Repos
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/*
created by Mansy 30/4/2022
 */
class PostsVM(
    application: Application,
    private val repositories: Repos,
) : BaseViewModel(application) {
    @ExperimentalCoroutinesApi
//    private val posts = MutableStateFlow<Resource<List<PostEntityItem>>>(Resource.loading(null))
    var posts by mutableStateOf<Resource<List<PostEntityItem>>>(Resource.loading(null))

    @ExperimentalCoroutinesApi
    fun requestPosts() {
        viewModelScope.launch {
            repositories.getPostsRepo.getPosts().catch { e ->
                posts = (Resource.error(e.message.toString(), null))
            }.collect {
                posts = Resource.success(it)
            }
        }
    }

}