package com.dubizzle.androidtask.di

import android.app.Application
import android.content.Context
import com.dubizzle.androidtask.ui.DetailActivity
import com.dubizzle.androidtask.ui.HomeActivity
import com.dubizzle.androidtask.ui.ListingsAdapter
import dagger.Module
import dagger.Binds
import dagger.android.ContributesAndroidInjector



@Module
abstract class AppModule {

    // This annotation provides a replacement of @Provides methods which simply return the injected parameter
    @Binds
    abstract fun bindContext(application: Application): Context


    @ContributesAndroidInjector
    internal abstract fun contributesHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    internal abstract fun contributesDetailActivity(): DetailActivity

    @ContributesAndroidInjector
    internal abstract fun contributesListingsAdapter(): ListingsAdapter

}