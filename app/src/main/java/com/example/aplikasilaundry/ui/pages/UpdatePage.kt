package com.example.aplikasilaundry.ui.pages

import com.example.aplikasilaundry.R
import com.example.aplikasilaundry.navigasi.DestinasiHalaman

object UpdateDestinasi : DestinasiHalaman {
    override val route = "item_edit"
    override val judulHal = R.string.edit
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}