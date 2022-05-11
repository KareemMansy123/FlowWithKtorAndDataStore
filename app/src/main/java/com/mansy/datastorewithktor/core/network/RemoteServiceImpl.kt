package com.mansy.datastorewithktor.core.network

import com.mansy.datastorewithktor.data.remote.entites.PostEntityItem
import com.mansy.datastorewithktor.data.remote.interfaces.ApiService
import io.ktor.client.*
import kotlinx.coroutines.flow.flow

/*
created by Mansy 30/4/2022
 */
class RemoteServiceImpl(
    private val client: HttpClient
) : ApiService {
    override suspend fun getPosts() = flow<List<PostEntityItem>> {
        emit(handler(Routes.Posts.url, client = client))
    }
}