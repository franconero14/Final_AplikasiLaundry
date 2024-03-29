package com.example.aplikasilaundry.ui.pages

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.data.Pesanan
import com.example.aplikasilaundry.navigasi.DestinasiHalaman
import com.example.aplikasilaundry.navigasi.LaundryAppBar
import com.example.aplikasilaundry.ui.model.ItemDetailUiState
import com.example.aplikasilaundry.ui.model.PenyediaViewModel
import com.example.aplikasilaundry.ui.model.ResultViewModel
import com.example.aplikasilaundry.ui.model.toLaundry
import kotlinx.coroutines.launch

object DataDestinasi : DestinasiHalaman {
    override val route = "item_details"
    override val judulHal = R.string.data_pesanan
    const val laundryIdArg = "itemId"
    val routeWithArgs = "$route/{$laundryIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ResultViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiState = viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            LaundryAppBar(
                title = stringResource(DataDestinasi.judulHal),
                bisaNavigasiBack = true,
                navigasiUp = navigateBack
            )
        },
        modifier = modifier
    ) { innerPadding ->
        ItemDetailsBody(
            itemDetailUiState = uiState.value,
            onDelete = {
                coroutineScope.launch {
                    viewModel.deleteItem()
                    navigateBack()
                }
            },
            navigateToItemEdit = { navigateToEditItem(uiState.value.detailLaundry.id) },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(
                    rememberScrollState()
                ),

            )
    }
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
        var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }
        ItemDetails(
            pesanan = itemDetailUiState.detailLaundry.toLaundry(),
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = navigateToItemEdit, shape = MaterialTheme.shapes.small

            ) {
                Text(text = "Update")
            }
            OutlinedButton(
                onClick = { deleteConfirmationRequired = true },
                shape = MaterialTheme.shapes.small

            ) {
                Text("Hapus")
            }
            if (deleteConfirmationRequired) {
                DeleteDialog(
                    onDeleteConfirm = {
                        deleteConfirmationRequired = false
                        onDelete()
                    },
                    onDeleteCancel = { deleteConfirmationRequired = false },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
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
            ItemDetailRow(
                labelResID = R.string.hargaUser,
                itemDetail = pesanan.harga,
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

@Composable
private fun DeleteDialog(
    onDeleteConfirm: () -> Unit,
    onDeleteCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text(text = "Perhatian!") },
        text = { Text(text = "Yakin ingin hapus data?") },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = "Tidak")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = "Iya")
            }
        }
    )
}