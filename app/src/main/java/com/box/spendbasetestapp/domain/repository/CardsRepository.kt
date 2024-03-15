package com.box.spendbasetestapp.domain.repository

import com.box.spendbasetestapp.domain.model.CardDomain
import com.box.spendbasetestapp.domain.model.TransactionDomain
import kotlinx.coroutines.flow.Flow

interface CardsRepository {

    suspend fun getAllCards() : Flow<List<CardDomain>>

    suspend fun getAllTransaction() : Flow<List<TransactionDomain>>

    suspend fun getCardDetailsById(id: String) : Flow<CardDomain>

    suspend fun getTransactionByCardId(id: String) : Flow<List<TransactionDomain>>

}