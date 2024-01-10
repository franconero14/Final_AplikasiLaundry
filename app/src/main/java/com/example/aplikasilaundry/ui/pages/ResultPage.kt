package com.example.aplikasilaundry.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.aplikasilaundry.R
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

}