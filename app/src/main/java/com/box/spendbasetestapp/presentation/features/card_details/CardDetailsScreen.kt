package com.box.spendbasetestapp.presentation.features.card_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.box.spendbasetestapp.R
import com.box.spendbasetestapp.presentation.features.card_details.model.UiCardDetailsButtonModel
import com.box.spendbasetestapp.presentation.features.card_details.model.UiCardDetailsButtonType
import com.box.spendbasetestapp.presentation.model.UITransaction
import com.box.spendbasetestapp.ui.components.TransactionItem
import com.box.spendbasetestapp.ui.theme.SpendbaseTestAppTheme
import com.box.spendbasetestapp.ui.theme.neutral200
import com.box.spendbasetestapp.ui.theme.neutral500
import com.box.spendbasetestapp.ui.theme.neutral800
import com.box.spendbasetestapp.ui.theme.white
import java.time.format.DateTimeFormatter

@Composable
fun CardDetailsRoute(
    onBackClick: () -> Unit,
    cardId: String,
    viewModel: CardDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.setEvent(CardDetailsScreenContract.Event.FetchCardInfoById(cardId))
    }

    CardDetailsScreen(
        uiState = uiState,
        onEvent = viewModel::setEvent,
        onBackClick = onBackClick
    )
}

@Composable
fun CardDetailsScreen(
    uiState: CardDetailsScreenContract.State,
    onEvent: (CardDetailsScreenContract.Event) -> Unit,
    onBackClick: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            Header(
                onBackClick = onBackClick,
                cardName = uiState.card?.cardName ?: "",
                cardLast4 = uiState.card?.cardLast4 ?: ""
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            CardBlock(buttons = uiState.listOfButtons)
            Spacer(modifier = Modifier.height(20.dp))
        }

        items(uiState.transactions.keys.toList().reversed()) { date ->
            uiState.transactions[date]?.let {
                DayTransactions(
                    day = date.format(DateTimeFormatter.ofPattern("dd MMM")),
                    transaction = it
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun Header(
    onBackClick: () -> Unit,
    cardName: String,
    cardLast4: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back_24),
            contentDescription = null,
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onBackClick
                )
                .align(Alignment.CenterStart)
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = cardName,
                style = SpendbaseTestAppTheme.typography.headlineSmall
            )
            Text(
                text = "•• $cardLast4",
                style = SpendbaseTestAppTheme.typography.labelMedium,
                color = neutral500
            )
        }
    }
}

@Composable
fun CardBlock(
    buttons: List<UiCardDetailsButtonModel>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_card_large), contentDescription = null)
        Divider(
            thickness = 1.dp,
            color = neutral200
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = white, shape = RoundedCornerShape(14.dp))
                .width(256.dp)
        ) {
            buttons.forEach {
                CardActionButton(button = it, onClick = {})
            }
        }
    }
}

@Composable
fun CardActionButton(
    button: UiCardDetailsButtonModel,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(72.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(painter = painterResource(id = button.iconId), contentDescription = null)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(id = button.titleId),
                style = SpendbaseTestAppTheme.typography.labelSmall,
                color = neutral800
            )
        }
    }
}

@Composable
private fun DayTransactions(
    day: String,
    transaction: List<UITransaction>
) {
    Text(
        text = day,
        style = SpendbaseTestAppTheme.typography.labelMedium,
        color = neutral500,
        modifier = Modifier.offset(x = 10.dp)
    )
    Spacer(modifier = Modifier.height(12.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = white, shape = RoundedCornerShape(14.dp))
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ) {
        transaction.forEach {
            TransactionItem(
                transaction = it,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpendbaseTestAppPreview() {
    SpendbaseTestAppTheme {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            CardActionButton(
                button = UiCardDetailsButtonModel(
                    iconId = R.drawable.ic_eye,
                    titleId = R.string.details_title,
                    type = UiCardDetailsButtonType.DETAILS
                ),
                onClick = {}
            )
        }
    }
}