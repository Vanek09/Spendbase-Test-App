package com.box.spendbasetestapp.domain.usecase

import com.box.spendbasetestapp.domain.model.TransactionDomain
import com.box.spendbasetestapp.domain.repository.CardsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface Get3LastTransactionsUseCase {
    suspend operator fun invoke(): Flow<List<TransactionDomain>>
}

class Get3LastTransactionsUseCaseImpl @Inject constructor(
    private val cardsRepository: CardsRepository
) : Get3LastTransactionsUseCase {
    override suspend fun invoke() = cardsRepository
        .getAllTransaction()
        .map { transactions ->
            transactions
                .sortedByDescending {
                    it.completeDate
                }
                .take(3)
        }
}