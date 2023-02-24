package com.example.apptestingmvvm.di

import com.example.apptestingmvvm.repository.toCallRepo.ToCallRepository
import com.example.apptestingmvvm.repository.toCallRepo.ToCallRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ToCallModule {
    @Binds
    abstract fun provideCallRepository(toCallRepository: ToCallRepositoryImpl): ToCallRepository
}