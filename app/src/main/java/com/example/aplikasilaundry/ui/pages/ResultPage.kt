package com.example.aplikasilaundry.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.data.Pesanan
import com.example.aplikasilaundry.navigasi.DestinasiHalaman
import com.example.aplikasilaundry.ui.model.ItemDetailUiState

object DataDestinasi : DestinasiHalaman {
    override val route = "item_details"
    override val judulHal = R.string.data_pesanan
    const val laundryIdArg = "itemId"
    val routeWithArgs = "$route/{$laundryIdArg}"
}

@Composable
private fun ItemDetailsBody(
    itemDetailUiState: ItemDetailUiState,
    onDelete: () -> Unit,
    navigateToItemEdit: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
    }
}

@Composable
private fun ItemDetails(
    pesanan: Pesanan,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier, colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
    }
}