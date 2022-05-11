package com.mansy.datastorewithktor.data.remote.entites

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
/*
created by Mansy 30/4/2022
 */

@Serializable
data class PostEntityItem(
    @SerialName("body")
    val body: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("title")
    val title: String?,
    @SerialName("userId")
    val userId: Int?
)