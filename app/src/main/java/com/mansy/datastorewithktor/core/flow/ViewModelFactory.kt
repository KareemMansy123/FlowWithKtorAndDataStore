package com.mansy.datastorewithktor.core.flow

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mansy.datastorewithktor.data.repos.Repos
/*
created by Mansy 30/4/2022
 */
object ViewModelFactory : ViewModelProvider.Factory {

    private lateinit var repositories: Repos
    private lateinit var application: Application

    fun inject(application: Application, repositories: Repos) {
        this.repositories = repositories
        this.application = application
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (BaseViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, Repos::class.java)
                .newInstance(application, repositories)
        }
        throw IllegalArgumentException("Unknown class name")    }
}