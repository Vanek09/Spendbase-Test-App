/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.box.spendbasetestapp.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.box.spendbasetestapp.R

enum class TopLevelDestination(
    @DrawableRes val icon: Int,
    @StringRes val titleId: Int,
) {
    HOME(
        icon = R.drawable.ic_home,
        titleId = R.string.home_tab_title,
    ),
    TRANSACTIONS(
        icon = R.drawable.ic_transactions,
        titleId = R.string.transactions_tab_title,
    ),
    MY_CARDS(
        icon = R.drawable.ic_card,
        titleId = R.string.my_cards_tab_title,
    ),
    ACCOUNT(
        icon = R.drawable.ic_account,
        titleId = R.string.account_tab_title,
    )
}
