package com.example.aplikasilaundry.ui.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.data.Pesanan
import com.example.aplikasilaundry.navigasi.DestinasiHalaman
import com.example.aplikasilaundry.navigasi.LaundryAppBar
import com.example.aplikasilaundry.ui.model.OrderViewModel
import com.example.aplikasilaundry.ui.model.PenyediaViewModel

object OrderDestinasi : DestinasiHalaman {
    override val route = "home"
    override val judulHal = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PesananScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (Int) -> Unit = {},
    onNavigateBack: () -> Unit,
    viewModel: OrderViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LaundryAppBar(
                title = stringResource(id = OrderDestinasi.judulHal),
                bisaNavigasiBack = false,
                navigasiUp = { onNavigateBack })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry, shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.btn_add)
                )
            }
        }) { innerPadding ->
        val uiStatePesanan by viewModel.homeUiState.collectAsState()
        HomeBody(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            dataLaundry = uiStatePesanan.listPenyewa,
            onPesananClick = onDetailClick
        )
    }
}


@Composable
fun HomeBody(
    modifier: Modifier,
    dataLaundry: List<Pesanan>,
    onPesananClick: (Int) -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        if (dataLaundry.isEmpty()) {
            Text(text = "Tidak ada data pesananan", textAlign = TextAlign.Center)
        } else {
            Listpesanan(
                listLaundry = dataLaundry,
                onItemClick = { onPesananClick(it.id) },
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

    }
}

@Composable
fun Listpesanan(
    listLaundry: List<Pesanan>,
    modifier: Modifier = Modifier,
    onItemClick: (Pesanan) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            items = listLaundry,
            key = {
                it.id
            }
        ) { customer ->
            DataLaundry(
                pesanan = customer,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onItemClick(customer) })
        }
    }
}

@Composable
fun DataLaundry(
    pesanan: Pesanan,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.namaUser))
                Spacer(modifier = Modifier.weight(1f))
                Text(text = pesanan.nama)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.hpUser))
                Spacer(modifier = Modifier.weight(1f))
                Text(text = pesanan.nohp)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.alamatUser))
                Spacer(modifier = Modifier.weight(1f))
                Text(text = pesanan.alamat)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.hargaUser))
                Spacer(modifier = Modifier.weight(1f))
                Text(text = pesanan.harga)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.pewangi))
                Spacer(modifier = Modifier.weight(1f))
                Text(text = pesanan.wangi)
            }
        }
    }
}