package com.example.apptestingmvvm.di

import com.example.apptestingmvvm.repository.GetListAnimal
import com.example.apptestingmvvm.repository.GetListAnimalImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GetListAnimalModule {

    @Binds
    abstract fun provideGetListAnimalRepository(getListAnimalImpl: GetListAnimalImpl): GetListAnimal
}