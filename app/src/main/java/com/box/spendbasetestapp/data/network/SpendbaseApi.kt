package com.box.spendbasetestapp.data.network

import com.box.spendbasetestapp.data.network.model.response.CardsResponse
import com.box.spendbasetestapp.data.network.model.response.TransactionsResponse
import retrofit2.Response
import retrofit2.http.GET

interface SpendbaseApi {

    @GET("cards")
    suspend fun getCards(): Response<CardsResponse>

    @GET("cards/transactions")
    suspend fun getTransactions(): Response<TransactionsResponse>

}