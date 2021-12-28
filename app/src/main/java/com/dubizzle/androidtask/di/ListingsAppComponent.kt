package com.dubizzle.androidtask.di

import android.app.Application
import com.dubizzle.androidtask.application.ListingsApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DomainModule::class,
        DataModule::class,
        LocalPersistenceModule::class,
        RemoteModule::class,
        PresentationModule::class,
        AppModule::class
    ]
)
interface ListingsAppComponent : AndroidInjector<ListingsApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): ListingsAppComponent
    }

    override fun inject(app: ListingsApp)
}