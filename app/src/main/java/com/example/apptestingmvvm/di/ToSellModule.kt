package com.example.apptestingmvvm.di

import com.example.apptestingmvvm.repository.toSellRepo.ToSellRepository
import com.example.apptestingmvvm.repository.toSellRepo.ToSellRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ToSellModule {

    @Binds
    abstract fun provideToSellRepo(toSellRepositoryImpl: ToSellRepositoryImpl): ToSellRepository
}