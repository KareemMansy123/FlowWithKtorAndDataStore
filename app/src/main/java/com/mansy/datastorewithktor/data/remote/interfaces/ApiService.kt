package com.mansy.datastorewithktor.data.remote.interfaces

import com.mansy.datastorewithktor.data.remote.entites.PostEntityItem
import kotlinx.coroutines.flow.Flow

/*
created by Mansy 30/4/2022
 */
interface ApiService {
    suspend fun getPosts() : Flow<List<PostEntityItem>>
}