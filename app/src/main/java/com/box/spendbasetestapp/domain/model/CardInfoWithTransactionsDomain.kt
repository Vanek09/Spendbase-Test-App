package com.box.spendbasetestapp.domain.model

import java.time.LocalDate

data class CardInfoWithTransactionsDomain(
    val cardDomain: CardDomain,
    val transactions: Map<LocalDate, List<TransactionDomain>>
)