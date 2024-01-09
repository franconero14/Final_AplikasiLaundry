package com.example.aplikasilaundry.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.data.Pesanan

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