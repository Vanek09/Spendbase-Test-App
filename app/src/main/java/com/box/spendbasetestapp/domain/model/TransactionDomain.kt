package com.box.spendbasetestapp.domain.model

import java.time.LocalDateTime

data class TransactionDomain(
    val account: AccountDomain,
    val amount: Double,
    val attachments: List<AttachmentDomain>,
    val card: CardDomain?,
    val completeDate: LocalDateTime,
    val createDate: LocalDateTime,
    val id: String,
    val merchant: MerchantDomain,
    val origin: String,
    val publicId: String,
    val status: String,
    val type: String
)

data class AccountDomain(
    val accountLast4: String,
    val accountName: String,
    val accountType: String
) {
    companion object {
        fun default() = AccountDomain(
            accountLast4 = "",
            accountName = "",
            accountType = ""
        )
    }
}

data class MerchantDomain(
    val name: String
) {
    companion object {
        fun default() = MerchantDomain(
            name = ""
        )
    }
}

data class AttachmentDomain(
    val createdAt: LocalDateTime,
    val externalTransactionId: String,
    val fileName: String,
    val fileSize: String,
    val fileType: String,
    val fileUrl: String,
    val id: String,
    val note: String,
    val sourceId: String,
    val transactionId: String,
    val updatedAt: LocalDateTime
)