package com.george.skadiweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SkadiWeatherApplication :Application(){
    companion object{
        const val TOKEN="PsD4lhfRQXlE2xUR"

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}