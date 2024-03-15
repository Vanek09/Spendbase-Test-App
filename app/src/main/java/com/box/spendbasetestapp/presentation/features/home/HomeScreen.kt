package com.box.spendbasetestapp.presentation.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.box.spendbasetestapp.presentation.model.UICard
import com.box.spendbasetestapp.presentation.model.UITransaction
import com.box.spendbasetestapp.ui.components.TransactionItem
import com.box.spendbasetestapp.ui.theme.SpendbaseTestAppTheme
import com.box.spendbasetestapp.ui.theme.blue500
import com.box.spendbasetestapp.ui.theme.neutral500
import com.box.spendbasetestapp.ui.theme.neutral800
import com.box.spendbasetestapp.ui.theme.neutral900
import com.box.spendbasetestapp.ui.theme.white
import com.box.spendbasetestapp.ui.theme.white20

@Composable
fun HomeRoute(
    onNavigateToCardDetails: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState,
        onEvent = viewModel::setEvent,
        onNavigateToCardDetails = onNavigateToCardDetails
    )
}

@Composable
fun HomeScreen(
    uiState: HomeScreenContract.State,
    onEvent: (HomeScreenContract.Event) -> Unit,
    onNavigateToCardDetails: (String) -> Unit

) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        item {
            Header()
        }

        item {
            AccountInfoBlock(amount = stringResource(id = R.string.eur_account_amount))
        }

        item {
            MyCardsBlock(
                cards = uiState.last3cards,
                onCardClick = onNavigateToCardDetails
            )
        }

        item {
            RecentTransactionsBlock(
                transactions = uiState.last3Transaction
            )
        }
    }
}

@Composable
private fun Header() {
    Text(
        text = stringResource(id = R.string.money_title),
        style = SpendbaseTestAppTheme.typography.headlineMedium
    )
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
private fun AccountInfoBlock(
    amount: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = white, shape = RoundedCornerShape(14.dp))
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_eur_flag), contentDescription = null)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = stringResource(id = R.string.eur_account),
                style = SpendbaseTestAppTheme.typography.labelLarge,
                color = neutral500
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = amount,
            style = SpendbaseTestAppTheme.typography.headlineMedium,
            color = neutral900
        )
    }
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
private fun MyCardsBlock(
    cards: List<UICard>,
    onCardClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = white, shape = RoundedCornerShape(14.dp))
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.my_cards_title),
                style = SpendbaseTestAppTheme.typography.headlineSmall,
                color = neutral800
            )
            Text(
                text = stringResource(id = R.string.see_all_title),
                style = SpendbaseTestAppTheme.typography.labelLarge,
                color = blue500
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        cards.forEach {
            CardItem(
                card = it,
                onClick = {
                    onCardClick(it.id)
                }
            )
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
private fun CardItem(
    card: UICard,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CardIcon(cardLast4 = card.cardLast4)
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = card.cardName,
            style = SpendbaseTestAppTheme.typography.labelLarge,
            color = neutral900
        )
    }
}

@Composable
private fun CardIcon(
    cardLast4: String,
) {
    Box(
        modifier = Modifier
            .width(48.dp)
            .height(32.dp)
            .background(color = neutral800, shape = RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = white20, shape = RoundedCornerShape(4.dp))
    ) {
        Text(
            text = cardLast4,
            color = white,
            style = SpendbaseTestAppTheme.typography.labelSmall,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 4.dp)
        )
    }
}

@Composable
private fun RecentTransactionsBlock(
    transactions: List<UITransaction>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = white, shape = RoundedCornerShape(14.dp))
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.recent_transactions_title),
                style = SpendbaseTestAppTheme.typography.headlineSmall,
                color = neutral800
            )
            Text(
                text = stringResource(id = R.string.see_all_title),
                style = SpendbaseTestAppTheme.typography.labelLarge,
                color = blue500
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        transactions.forEach {
            TransactionItem(
                transaction = it,
                onClick = {

                }
            )
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
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


        }
    }
}