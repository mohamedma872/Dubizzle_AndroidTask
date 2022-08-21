package com.dubizzle.androidtask.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
//app module no longer needed
abstract class AppModule {

    // This annotation provides a replacement of @Provides methods which simply return the injected parameter





}