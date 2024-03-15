package com.box.spendbasetestapp.data.network.model.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CardsResponse(
    @SerializedName("cards")
    val cards: List<Card>?
)

@Keep
data class Card(
    @SerializedName("cardHolder")
    val cardHolder: CardHolder?,
    @SerializedName("cardLast4")
    val cardLast4: String?,
    @SerializedName("cardName")
    val cardName: String?,
    @SerializedName("fundingSource")
    val fundingSource: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isLocked")
    val isLocked: Boolean?,
    @SerializedName("isTerminated")
    val isTerminated: Boolean?,
    @SerializedName("issuedAt")
    val issuedAt: String?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("limitType")
    val limitType: String?,
    @SerializedName("spent")
    val spent: Int?
)

@Keep
data class CardHolder(
    @SerializedName("email")
    val email: String?,
    @SerializedName("fullName")
    val fullName: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("logoUrl")
    val logoUrl: String?
)