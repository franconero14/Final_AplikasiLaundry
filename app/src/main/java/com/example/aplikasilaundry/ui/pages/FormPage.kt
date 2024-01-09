package com.example.aplikasilaundry.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.data.DataPewangi.paket
import com.example.aplikasilaundry.navigasi.DestinasiHalaman
import com.example.aplikasilaundry.navigasi.LaundryAppBar
import com.example.aplikasilaundry.ui.model.DetailLaundry
import com.example.aplikasilaundry.ui.model.FormViewModel
import com.example.aplikasilaundry.ui.model.PenyediaViewModel
import com.example.aplikasilaundry.ui.model.UIStatePesanan
import kotlinx.coroutines.launch

object FormDestinasi : DestinasiHalaman {
    override val route = "item_entry"
    override val judulHal = R.string.form
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryPesananScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FormViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LaundryAppBar(
                title = stringResource(id = FormDestinasi.judulHal),
                bisaNavigasiBack = true,
                navigasiUp = navigateBack
            )
        }
    ) {
            innerPadding ->
        EntryPesananBody(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            uiStatePenyewa = viewModel.uiStatePesanan,
            onPenyewaValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.savePesanan()
                    navigateBack()
                }
            }
        )
    }
}

@Composable
fun EntryPesananBody(
    uiStatePenyewa: UIStatePesanan,
    onPenyewaValueChange: (DetailLaundry) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        FormInputPesanan(
            detailLaundry = uiStatePenyewa.detailLaundry,
            onValueChange = onPenyewaValueChange,
            pilihanSewa = paket.map { id -> context.resources.getString(id) },
            onSelectionChanged = { uiStatePenyewa.detailLaundry.wangi }
        )
        Button(
            onClick = onSaveClick,
            enabled = uiStatePenyewa.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "CHECKOUT")
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputPesanan(
    detailLaundry: DetailLaundry,
    modifier: Modifier = Modifier,
    onValueChange: (DetailLaundry) -> Unit = {},
    enabled: Boolean = true,
    pilihanSewa: List<String>,
    onSelectionChanged: (String) -> Unit

) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = modifier.padding(top = 24.dp))
        OutlinedTextField(
            value = detailLaundry.nama,
            onValueChange = { onValueChange(detailLaundry.copy(nama = it)) },
            label = { Text(text = stringResource(id = R.string.namaUser)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = detailLaundry.alamat,
            onValueChange = { onValueChange(detailLaundry.copy(alamat = it)) },
            label = { Text(text = stringResource(id = R.string.alamatUser)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = detailLaundry.nohp,
            onValueChange = { onValueChange(detailLaundry.copy(nohp = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = stringResource(id = R.string.hpUser)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        Column(
            modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.pewangi))
            pilihanSewa.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = detailLaundry.wangi == item,
                    onClick = {
                        onValueChange(detailLaundry.copy(wangi = item))
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = detailLaundry.wangi == item,
                        onClick = {
                            onValueChange(detailLaundry.copy(wangi = item))
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
        }
        OutlinedTextField(
            value = detailLaundry.harga,
            onValueChange = { onValueChange(detailLaundry.copy(harga = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = stringResource(id = R.string.hargaUser)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}