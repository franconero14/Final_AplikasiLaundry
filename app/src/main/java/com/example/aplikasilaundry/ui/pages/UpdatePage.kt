package com.example.aplikasilaundry.ui.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.navigasi.DestinasiHalaman
import com.example.aplikasilaundry.navigasi.LaundryAppBar
import com.example.aplikasilaundry.ui.model.PenyediaViewModel
import com.example.aplikasilaundry.ui.model.UpdateViewModel
import kotlinx.coroutines.launch

object UpdateDestinasi : DestinasiHalaman {
    override val route = "item_edit"
    override val judulHal = R.string.edit
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            LaundryAppBar(
                title = stringResource(UpdateDestinasi.judulHal),
                bisaNavigasiBack = true,
                navigasiUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        EntryPesananBody(
            uiStatePenyewa = viewModel.pesananUiState,
            onPenyewaValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updatePenyewa()
                    navigateBack()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )

    }
}