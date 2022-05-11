package com.mansy.datastorewithktor.presentation

import android.app.Application
import com.mansy.datastorewithktor.core.AppInjector
/*
created by Mansy 30/4/2022
 */
class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        setup()
    }
    private fun setup(){
    AppInjector(this).inject()
    }
}