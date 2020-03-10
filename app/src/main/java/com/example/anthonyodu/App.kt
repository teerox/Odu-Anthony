package com.example.anthonyodu

import android.app.Application
import com.example.anthonyodu.repository.FilterRepository

class App:Application(){
    val filterRepoInterface:FilterRepository
    get() = ServiceLocator.provideFilterRepository()

    override fun onCreate() {
        super.onCreate()
    }
}