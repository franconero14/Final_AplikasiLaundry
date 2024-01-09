package com.example.aplikasilaundry.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaundryAppBar(
    title: String,
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (bisaNavigasiBack) {
                IconButton(onClick = navigasiUp) {
                    Icons.Default.ArrowBack

                }
            }
        }
    )
}

@Composable
fun LaundryApp(navController: NavHostController = rememberNavController()) {
    PenyediaNavigasi(navController = navController)
}

@Composable
fun PenyediaNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

}