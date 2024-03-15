package com.box.spendbasetestapp.di

import com.box.spendbasetestapp.data.CardsRepositoryImpl
import com.box.spendbasetestapp.data.network.SpendbaseApi
import com.box.spendbasetestapp.domain.repository.CardsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideCardsRepository(spendbaseApi: SpendbaseApi): CardsRepository =
        CardsRepositoryImpl(spendbaseApi)
}