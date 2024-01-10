package com.example.aplikasilaundry.ui.pages

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ItemDetailRow(
                labelResID = R.string.namaUser,
                itemDetail = pesanan.nama,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            ItemDetailRow(
                labelResID = R.string.hpUser,
                itemDetail = pesanan.nohp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            ItemDetailRow(
                labelResID = R.string.alamatUser,
                itemDetail = pesanan.alamat,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            ItemDetailRow(
                labelResID = R.string.berat,
                itemDetail = pesanan.harga,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            ItemDetailRow(
                labelResID = R.string.pewangi,
                itemDetail = pesanan.wangi,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
private fun ItemDetailRow(
    @StringRes labelResID: Int, itemDetail: String, modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = stringResource(labelResID))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetail, fontWeight = FontWeight.Bold)
    }
}