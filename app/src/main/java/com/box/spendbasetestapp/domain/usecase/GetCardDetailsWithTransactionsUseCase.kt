package com.box.spendbasetestapp.domain.usecase

import com.box.spendbasetestapp.domain.model.CardInfoWithTransactionsDomain
import com.box.spendbasetestapp.domain.repository.CardsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

interface GetCardDetailsWithTransactionsUseCase {
    suspend operator fun invoke(id: String): Flow<CardInfoWithTransactionsDomain>
}

class GetCardDetailsWithTransactionsUseCaseImpl @Inject constructor(
    private val cardsRepository: CardsRepository
) : GetCardDetailsWithTransactionsUseCase {
    override suspend fun invoke(id: String): Flow<CardInfoWithTransactionsDomain> {
        val card = cardsRepository.getCardDetailsById(id)
        val transactions = cardsRepository.getTransactionByCardId(id)

        return card.combine(transactions) { cardDomain, transactionDomains ->
            CardInfoWithTransactionsDomain(
                cardDomain,
                transactionDomains
                    .groupBy { it.completeDate.toLocalDate() }
                    .toSortedMap()
            )
        }
    }

}
