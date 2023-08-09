package com.example.marvel

import android.app.Application
import com.example.marvel.di.dataModule
import com.example.marvel.di.domainModule
import com.example.marvel.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MarvelApplication: Application() {

    override fun onCreate() {
        super.onCreate()

       startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@MarvelApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )

        }
    }
}