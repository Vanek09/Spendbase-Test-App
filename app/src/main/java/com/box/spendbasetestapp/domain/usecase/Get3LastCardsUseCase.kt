package com.box.spendbasetestapp.domain.usecase

import com.box.spendbasetestapp.domain.model.CardDomain
import com.box.spendbasetestapp.domain.repository.CardsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface Get3LastCardsUseCase {
    suspend operator fun invoke(): Flow<List<CardDomain>>
}

class Get3LastCardsUseCaseImpl @Inject constructor(
    private val cardsRepository: CardsRepository
) : Get3LastCardsUseCase {
    override suspend fun invoke() = cardsRepository
        .getAllCards()
        .map { cards ->
            cards
                .sortedByDescending {
                    it.issuedAt
                }
                .take(3)
        }
}