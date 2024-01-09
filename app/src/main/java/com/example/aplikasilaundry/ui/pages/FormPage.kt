package com.example.aplikasilaundry.ui.pages

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplikasilaundry.R
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
) {}