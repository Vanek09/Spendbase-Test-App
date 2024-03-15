package com.box.spendbasetestapp.data.network.model.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class TransactionsResponse(
    @SerializedName("transactions")
    val transactions: List<Transaction>?
)

@Keep
data class Transaction(
    @SerializedName("account")
    val account: Account?,
    @SerializedName("amount")
    val amount: Double?,
    @SerializedName("attachments")
    val attachments: List<Attachment>?,
    @SerializedName("card")
    val card: Card?,
    @SerializedName("completeDate")
    val completeDate: String?,
    @SerializedName("createDate")
    val createDate: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("merchant")
    val merchant: Merchant?,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("publicId")
    val publicId: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("type")
    val type: String?
)

@Keep
data class Account(
    @SerializedName("accountLast4")
    val accountLast4: String?,
    @SerializedName("accountName")
    val accountName: String?,
    @SerializedName("accountType")
    val accountType: String?
)

@Keep
data class Merchant(
    @SerializedName("icon")
    val icon: Any?,
    @SerializedName("name")
    val name: String?
)

@Keep
data class Attachment(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("deletedAt")
    val deletedAt: Any?,
    @SerializedName("externalTransactionId")
    val externalTransactionId: String?,
    @SerializedName("fileName")
    val fileName: String?,
    @SerializedName("fileSize")
    val fileSize: String?,
    @SerializedName("fileType")
    val fileType: String?,
    @SerializedName("fileUrl")
    val fileUrl: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("note")
    val note: String?,
    @SerializedName("sourceId")
    val sourceId: String?,
    @SerializedName("transactionId")
    val transactionId: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)