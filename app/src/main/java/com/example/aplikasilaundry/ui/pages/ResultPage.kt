package com.example.aplikasilaundry.ui.pages

import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.navigasi.DestinasiHalaman

object DataDestinasi : DestinasiHalaman {
    override val route = "item_details"
    override val judulHal = R.string.data_pesanan
    const val laundryIdArg = "itemId"
    val routeWithArgs = "$route/{$laundryIdArg}"
}