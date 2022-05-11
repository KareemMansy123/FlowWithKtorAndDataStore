package com.mansy.datastorewithktor.core

import android.app.Application
import com.mansy.datastorewithktor.core.flow.ViewModelFactory
import com.mansy.datastorewithktor.core.network.RemoteService
import com.mansy.datastorewithktor.data.repos.DataStoreRepo
import com.mansy.datastorewithktor.data.repos.GetPostsRepo
import com.mansy.datastorewithktor.data.repos.Repos
/*
created by Mansy 30/4/2022
 */
class AppInjector(private val application: Application) {
     fun inject() {
        val remoteServiceImpl = RemoteService().remoteService
        val postsRepo = GetPostsRepo(remoteServiceImpl)
//        val storeRepo = DataStoreRepo(application)
        val repos = Repos(postsRepo)
        ViewModelFactory.inject(application, repos)
    }
}