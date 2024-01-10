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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aplikasilaundry.ui.pages.DataDestinasi
import com.example.aplikasilaundry.ui.pages.DetailScreen
import com.example.aplikasilaundry.ui.pages.EntryPesananScreen
import com.example.aplikasilaundry.ui.pages.FormDestinasi
import com.example.aplikasilaundry.ui.pages.HomeDestinasi
import com.example.aplikasilaundry.ui.pages.Homepage
import com.example.aplikasilaundry.ui.pages.ItemEditScreen
import com.example.aplikasilaundry.ui.pages.OrderDestinasi
import com.example.aplikasilaundry.ui.pages.PesananScreen
import com.example.aplikasilaundry.ui.pages.UpdateDestinasi

enum class PengelolaHalaman {
    Home,
    Entry
}
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
    NavHost(navController = navController, startDestination = HomeDestinasi.route) {
        composable(HomeDestinasi.route) {
            Homepage(
                onNextButtonClicked = { navController.navigate(OrderDestinasi.route) }
            )
        }
        composable(OrderDestinasi.route) {
            PesananScreen(
                navigateToItemEntry = { navController.navigate(FormDestinasi.route) },
                onNavigateBack = { navController.popBackStack() },
                onDetailClick = { itemId -> navController.navigate("${DataDestinasi.route}/$itemId") }
            )
        }
    }
}