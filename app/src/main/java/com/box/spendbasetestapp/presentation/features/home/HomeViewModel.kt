package com.box.spendbasetestapp.presentation.features.home

import com.box.spendbasetestapp.base.BaseViewModel
import com.box.spendbasetestapp.domain.usecase.Get3LastCardsUseCase
import com.box.spendbasetestapp.domain.usecase.Get3LastTransactionsUseCase
import com.box.spendbasetestapp.presentation.mapper.toListOfUICard
import com.box.spendbasetestapp.presentation.mapper.toListOfUITransaction
import com.box.spendbasetestapp.utils.subscribe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val get3LastCardsUseCase: Get3LastCardsUseCase,
    private val get3LastTransactionsUseCase: Get3LastTransactionsUseCase
) : BaseViewModel<HomeScreenContract.State, HomeScreenContract.Event, HomeScreenContract.Effect>() {

    init {
        fetchData()
    }

    override fun createInitialState() = HomeScreenContract.State.initial()

    override fun handleEvent(event: HomeScreenContract.Event) {
        when (event) {
            else -> {}
        }
    }

    private fun fetchData() {
        launch {
            launch { get3lastCards() }
            launch { get3LastTransactions() }
        }
    }

    private suspend fun get3lastCards() {
        setState { copy(isLoading = true) }
        get3LastCardsUseCase().subscribe(
            scope = this,
            success = { cards ->
                setState {
                    copy(last3cards = cards.toListOfUICard())
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

    private suspend fun get3LastTransactions() {
        setState { copy(isLoading = true) }
        get3LastTransactionsUseCase().subscribe(
            scope = this,
            success = { transactions ->
                setState {
                    copy(last3Transaction = transactions.toListOfUITransaction())
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
