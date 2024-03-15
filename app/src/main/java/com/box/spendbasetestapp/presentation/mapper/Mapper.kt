package com.box.spendbasetestapp.presentation.mapper

import com.box.spendbasetestapp.domain.model.CardDomain
import com.box.spendbasetestapp.domain.model.TransactionDomain
import com.box.spendbasetestapp.presentation.model.UICard
import com.box.spendbasetestapp.presentation.model.UITransaction

fun CardDomain.toUICard() = UICard(
    id = id,
    cardLast4 = cardLast4,
    cardName = cardName,
)

fun TransactionDomain.toUITransaction() = UITransaction(
    id = id,
    card = card?.toUICard(),
    amount = amount,
    completeDate = completeDate,
    isAttached = attachments.isNotEmpty()
)

fun List<CardDomain>.toListOfUICard() = map { it.toUICard() }

fun List<TransactionDomain>.toListOfUITransaction() = map { it.toUITransaction() }