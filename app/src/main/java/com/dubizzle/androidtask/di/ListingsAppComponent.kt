package com.dubizzle.androidtask.di

import com.dubizzle.androidtask.application.ListingsApp
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(
    includes = [
        AndroidInjectionModule::class,
        DomainModule::class,
        DataModule::class,
        LocalPersistenceModule::class,
        RemoteModule::class,
        PresentationModule::class,
        AppModule::class
    ]
)
//removed dagger custom component builder as it's not needed by hilt
//injected app context for database initialization using @ApplicationContext
interface ListingsAppComponent : AndroidInjector<ListingsApp> {




}