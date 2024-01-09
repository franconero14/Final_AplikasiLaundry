package com.example.aplikasilaundry.ui.pages

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.navigasi.DestinasiHalaman
import com.example.aplikasilaundry.ui.model.FormViewModel
import com.example.aplikasilaundry.ui.model.PenyediaViewModel

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

}