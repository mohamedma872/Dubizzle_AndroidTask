package com.dubizzle.androidtask.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dubizzle.domain.entities.FormEntity
import com.dubizzle.domain.entities.ListingsEntity
import com.dubizzle.presentation.factory.ViewModelFactory
import com.dubizzle.presentation.mapper.FormEntityMapper
import com.dubizzle.presentation.mapper.ListingsEntityMapper
import com.dubizzle.presentation.mapper.Mapper
import com.dubizzle.presentation.model.Form
import com.dubizzle.presentation.model.Listings
import com.dubizzle.presentation.viewmodel.FormViewModel
import com.dubizzle.presentation.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class PresentationModule {

    @Binds
    abstract fun bindsViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(homeVM: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FormViewModel::class)
    abstract fun bindsFormViewModel(formVM: FormViewModel): ViewModel

    @Binds
    abstract fun bindsListingsMapper(
        listingsEntityMapper: ListingsEntityMapper
    ): Mapper<ListingsEntity, Listings>

    @Binds
    abstract fun bindsFormMapper(
        formEntityMapper: FormEntityMapper
    ): Mapper<FormEntity, Form>


}