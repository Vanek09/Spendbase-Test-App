package com.box.spendbasetestapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.box.spendbasetestapp.R
import com.box.spendbasetestapp.presentation.model.UITransaction
import com.box.spendbasetestapp.ui.theme.SpendbaseTestAppTheme
import com.box.spendbasetestapp.ui.theme.green00AC4F
import com.box.spendbasetestapp.ui.theme.neutral500
import com.box.spendbasetestapp.ui.theme.neutral800


@Composable
fun TransactionItem(
    transaction: UITransaction,
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
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = if (transaction.card != null) R.drawable.ic_transfer_card else R.drawable.ic_transfer_in),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = if (transaction.card != null) transaction.card.cardName else stringResource(
                        id = R.string.transfer_in_title
                    ),
                    style = SpendbaseTestAppTheme.typography.labelLarge,
                    color = neutral800
                )
                transaction.card?.let {
                    Text(
                        text = "•• ${it.cardLast4}",
                        style = SpendbaseTestAppTheme.typography.labelMedium,
                        color = neutral500
                    )
                }
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "${transaction.amount} €",
                style = SpendbaseTestAppTheme.typography.labelMedium,
                color = if (transaction.amount > 0) green00AC4F else neutral800
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = if (transaction.isAttached) R.drawable.ic_attachment else R.drawable.ic_no_attachment),
                contentDescription = null
            )
        }
    }
}
