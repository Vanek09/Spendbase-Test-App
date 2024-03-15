package com.box.spendbasetestapp.presentation.features.card_details

import com.box.spendbasetestapp.base.BaseViewModel
import com.box.spendbasetestapp.domain.usecase.GetCardDetailsWithTransactionsUseCase
import com.box.spendbasetestapp.presentation.mapper.toListOfUITransaction
import com.box.spendbasetestapp.presentation.mapper.toUICard
import com.box.spendbasetestapp.utils.subscribe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardDetailsViewModel @Inject constructor(
    private val getCardDetailsWithTransactionsUseCase: GetCardDetailsWithTransactionsUseCase
) : BaseViewModel<CardDetailsScreenContract.State, CardDetailsScreenContract.Event, CardDetailsScreenContract.Effect>() {

    override fun createInitialState() = CardDetailsScreenContract.State.initial()

    override fun handleEvent(event: CardDetailsScreenContract.Event) {
        when (event) {
            is CardDetailsScreenContract.Event.FetchCardInfoById -> fetchCardInfoById(event.id)
        }
    }

    private fun fetchCardInfoById(id: String) {
        launch {
            setState { copy(isLoading = true) }
            getCardDetailsWithTransactionsUseCase(id).subscribe(
                this,
                success = { cardInfoWithTransactions ->
                    setState {
                        copy(
                            card = cardInfoWithTransactions.cardDomain.toUICard(),
                            transactions = cardInfoWithTransactions.transactions.mapValues {
                                it.value
                                    .toListOfUITransaction()
                                    .sortedByDescending { transaction -> transaction.completeDate }
                            }
                        )
                    }
                },
                error = {
                    it.printStackTrace()
                },
                complete = {
                    setState { copy(isLoading = false) }
                }
            )
        }
    }
}
