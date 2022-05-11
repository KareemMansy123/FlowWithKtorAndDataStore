package com.mansy.datastorewithktor.core.network

import android.util.Log
import com.mansy.datastorewithktor.core.network.ApiRoutes.BASE_URL
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
/*
created by Mansy 30/4/2022
 */
suspend inline fun <reified T> handler(url: String, client: HttpClient): T {

    return try {
        client.get {
            url("${BASE_URL}$url")
//            parameter()
//            headers {}
        }
    } catch (e: RedirectResponseException) {
        Log.e("KtorExceptionRedirect", "getPosts: ${e.response.status.description}")
//        emptyList()
        return e.message as T
    } catch (e: ClientRequestException) {
        Log.e("KtorExceptionClient", "getPosts: ${e.response.status.description}")
//        emptyList()
        return e.message as T
    } catch (e: ServerResponseException) {
        Log.e("KtorExceptionServer", "getPosts: ${e.response.status.description}")
//        emptyList()
        return e.message as T
    } catch (e: Exception) {
        Log.e("KtorException", "getPosts: ${e.message}")
//        emptyList()
        return e.message as T
    }
}
