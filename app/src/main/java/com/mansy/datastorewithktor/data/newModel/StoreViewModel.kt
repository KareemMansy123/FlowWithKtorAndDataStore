package com.mansy.datastorewithktor.data.newModel

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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StoreViewModel(
    application: Application,
//    private val repositories: Repos,
) : BaseViewModel(application) {
//    var data by mutableStateOf<Resource<List<PostEntityItem>>>(Resource.loading(null))
//
//    @ExperimentalCoroutinesApi
//    fun storeData(titles: List<PostEntityItem>) {
//        viewModelScope.launch {
//            repositories.dataStoreRepo.saveToStore(title = titles)
//        }
//    }
//
//    @ExperimentalCoroutinesApi
//    fun getData(){
//        viewModelScope.launch {
//            repositories.dataStoreRepo.getData().catch { e ->
//                data = (Resource.error(e.message.toString(), null))
//            }.collect {
//                data = Resource.success(it) as Resource<List<PostEntityItem>>
//            }

//            repositories.dataStoreRepo.titleFlow.catch { e ->
//                data = (Resource.error(e.message.toString(), null))
//            }.collect {
//                data = Resource.success(it)
//            }
//        }
//    }
}