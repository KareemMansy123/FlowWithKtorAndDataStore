package com.mansy.datastorewithktor.data.repos

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.mansy.datastorewithktor.data.remote.entites.PostEntityItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/*
created by Mansy 30/4/2022
 */
private const val preferenceName = "preference"

class DataStoreRepo(context: Context) {
    private val dataStore = context.createDataStore(preferenceName)

    companion object {
        val Title = preferencesKey<List<PostEntityItem>>("PostEntityItem")
    }

    suspend fun saveToStore(title: List<PostEntityItem>) {
        dataStore.edit {
            it[Title] = title
        }
    }

    fun getData() : Flow<Preferences> {
        return dataStore.data
    }

    val titleFlow: Flow<List<PostEntityItem>> = dataStore.data.catch { e ->
        if (e is IOException) emit(emptyPreferences())
        else {
            throw e
        }
    }.map {
        val titles = it[Title] ?: emptyList()
        titles
    }
}