package com.example.apptestingmvvm.di

import com.example.apptestingmvvm.domain.repository.toBuyRepo.ToBuyRepository
import com.example.apptestingmvvm.domain.repository.toBuyRepo.ToBuyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ToBuyModule {
    @Binds
    abstract fun provideToBuyRepository(toBuyRepositoryImpl: ToBuyRepositoryImpl): ToBuyRepository
}