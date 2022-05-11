package com.mansy.datastorewithktor.data.repos

import com.mansy.datastorewithktor.data.remote.entites.PostEntityItem
import com.mansy.datastorewithktor.data.remote.interfaces.ApiService
import kotlinx.coroutines.flow.Flow

/*
created by Mansy 30/4/2022
 */
class GetPostsRepo(private val apiService: ApiService) {
    suspend fun getPosts(
    ): Flow<List<PostEntityItem>> {
        return apiService.getPosts()
    }
}