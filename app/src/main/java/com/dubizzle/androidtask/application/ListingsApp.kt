package com.dubizzle.androidtask.application

import com.dubizzle.androidtask.di.DaggerListingsAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ListingsApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerListingsAppComponent.builder().application(this).build()
    }
}