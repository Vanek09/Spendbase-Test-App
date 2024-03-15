package com.box.spendbasetestapp.di

import com.box.spendbasetestapp.domain.repository.CardsRepository
import com.box.spendbasetestapp.domain.usecase.Get3LastCardsUseCase
import com.box.spendbasetestapp.domain.usecase.Get3LastCardsUseCaseImpl
import com.box.spendbasetestapp.domain.usecase.Get3LastTransactionsUseCase
import com.box.spendbasetestapp.domain.usecase.Get3LastTransactionsUseCaseImpl
import com.box.spendbasetestapp.domain.usecase.GetCardDetailsWithTransactionsUseCase
import com.box.spendbasetestapp.domain.usecase.GetCardDetailsWithTransactionsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    fun provideGet3LastCardsUseCase(cardsRepository: CardsRepository): Get3LastCardsUseCase =
        Get3LastCardsUseCaseImpl(cardsRepository)

    @Provides
    fun provideGet3LastTransactionsUseCase(cardsRepository: CardsRepository): Get3LastTransactionsUseCase =
        Get3LastTransactionsUseCaseImpl(cardsRepository)

    @Provides
    fun provideGetCardDetailsWithTransactionsUseCase(cardsRepository: CardsRepository): GetCardDetailsWithTransactionsUseCase =
        GetCardDetailsWithTransactionsUseCaseImpl(cardsRepository)
}