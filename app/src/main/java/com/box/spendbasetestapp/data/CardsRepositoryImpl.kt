package com.box.spendbasetestapp.data

import com.box.spendbasetestapp.data.mapper.toCardDomain
import com.box.spendbasetestapp.data.mapper.toListOfCardsDomain
import com.box.spendbasetestapp.data.mapper.toListOfTransactionsDomain
import com.box.spendbasetestapp.data.network.SpendbaseApi
import com.box.spendbasetestapp.domain.repository.CardsRepository
import com.box.spendbasetestapp.utils.NetworkException
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CardsRepositoryImpl @Inject constructor(
    private val spendbaseApi: SpendbaseApi
) : CardsRepository {

    override suspend fun getAllCards() = flow {
        val response = spendbaseApi.getCards()

        if (response.isSuccessful) {
            response.body()?.cards?.let {
                emit(it.toListOfCardsDomain())
            }
        } else {
            throw NetworkException(response.code())
        }
    }

    override suspend fun getAllTransaction() = flow {
        val response = spendbaseApi.getTransactions()

        if (response.isSuccessful) {
            response.body()?.transactions?.let {
                emit(it.toListOfTransactionsDomain())
            }
        } else {
            throw NetworkException(response.code())
        }
    }

    override suspend fun getCardDetailsById(id: String) = flow {
        val response = spendbaseApi.getCards()

        if (response.isSuccessful) {
            response.body()?.cards?.let { cards ->
                val card = cards.first { it.id == id }
                emit(card.toCardDomain())
            }
        } else {
            throw NetworkException(response.code())
        }
    }

    override suspend fun getTransactionByCardId(id: String) = flow {
        val response = spendbaseApi.getTransactions()

        if (response.isSuccessful) {
            response.body()?.transactions?.let { transactions ->
                emit(transactions
                    .toListOfTransactionsDomain()
                    .filter { it.card?.id == id }
                )
            }
        } else {
            throw NetworkException(response.code())
        }
    }
}