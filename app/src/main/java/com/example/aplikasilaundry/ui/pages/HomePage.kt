package com.example.aplikasilaundry.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.navigasi.DestinasiHalaman

object HomeDestinasi : DestinasiHalaman {
    override val route = "laundry"
    override val judulHal = R.string.app_name
}

@Composable
fun Homepage(
    onNextButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.dp, Color.Cyan),
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
                Text(
                    text = "Aplikasi",
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 35.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )
                Text(
                    text = "Laundry",
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 55.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            }
        }
    }
}