package com.box.spendbasetestapp.data.mapper

import com.box.spendbasetestapp.data.network.model.response.Account
import com.box.spendbasetestapp.data.network.model.response.Attachment
import com.box.spendbasetestapp.data.network.model.response.Card
import com.box.spendbasetestapp.data.network.model.response.Merchant
import com.box.spendbasetestapp.data.network.model.response.Transaction
import com.box.spendbasetestapp.domain.model.AccountDomain
import com.box.spendbasetestapp.domain.model.AttachmentDomain
import com.box.spendbasetestapp.domain.model.CardDomain
import com.box.spendbasetestapp.domain.model.MerchantDomain
import com.box.spendbasetestapp.domain.model.TransactionDomain
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun List<Card>.toListOfCardsDomain() = map { it.toCardDomain() }

fun List<Transaction>.toListOfTransactionsDomain() = map { it.toTransactionDomain() }

fun Card.toCardDomain() = CardDomain(
    cardLast4 = cardLast4 ?: "",
    cardName = cardName ?: "",
    fundingSource = fundingSource ?: "",
    id = id ?: "",
    isLocked = isLocked ?: false,
    isTerminated = isTerminated ?: false,
    issuedAt = LocalDateTime.parse(issuedAt, DateTimeFormatter.ISO_DATE_TIME),
    limit = limit ?: 0,
    limitType = limitType ?: "",
    spent = spent ?: 0,
    cardHolderEmail = cardHolder?.email ?: "",
    cardHolderFullName = cardHolder?.fullName ?: "",
    cardHolderId = cardHolder?.id ?: "",
    cardHolderLogoUrl = cardHolder?.logoUrl ?: ""
)

fun Transaction.toTransactionDomain() = TransactionDomain(
    amount = amount ?: 0.0,
    card = card?.toCardDomain(),
    completeDate = LocalDateTime.parse(completeDate, DateTimeFormatter.ISO_DATE_TIME),
    createDate = LocalDateTime.parse(createDate, DateTimeFormatter.ISO_DATE_TIME),
    id = id ?: "",
    origin = origin ?: "",
    publicId = publicId ?: "",
    status = status ?: "",
    type = type ?: "",
    merchant = merchant?.toMerchantDomain() ?: MerchantDomain.default(),
    account = account?.toAccountDomain() ?: AccountDomain.default(),
    attachments = attachments?.toListOfAttachmentDomain() ?: emptyList(),
)

fun Merchant.toMerchantDomain() = MerchantDomain(
    name = name ?: ""
)

fun Account.toAccountDomain() = AccountDomain(
    accountLast4 = accountLast4 ?: "",
    accountName = accountName ?: "",
    accountType = accountType ?: ""
)

fun Attachment.toAttachmentDomain() = AttachmentDomain(
    createdAt = LocalDateTime.parse(createdAt, DateTimeFormatter.ISO_DATE_TIME),
    externalTransactionId = externalTransactionId ?: "",
    fileName = fileName ?: "",
    fileSize = fileSize ?: "",
    fileType = fileType ?: "",
    fileUrl = fileUrl ?: "",
    id = id ?: "",
    note = note ?: "",
    sourceId = sourceId ?: "",
    transactionId = transactionId ?: "",
    updatedAt = LocalDateTime.parse(updatedAt, DateTimeFormatter.ISO_DATE_TIME)
)

fun List<Attachment>.toListOfAttachmentDomain() = map { it.toAttachmentDomain() }