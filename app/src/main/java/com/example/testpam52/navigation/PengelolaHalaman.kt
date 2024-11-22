package com.example.testpam52.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testpam52.ui.view.screen.MahasiwaFormView
import com.example.testpam52.ui.view.screen.SplashView

enum class Halaman {
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampildata
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    rencanaStudyViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){9
    +1

    val mahasiswaUiState = mahasiswaViewModel.statusUI.collectAsState().value
    var rencanaStudyState = rencanaStudyViewModel.krsStateUi.collectAsState().value
    NavHost(
        modifier = Modifier.padding(),
        navController = navController,
        startDestination = Halaman.Splash.name
    ) {
        composable(
            route = Halaman.Splash.name
        ) {
            SplashView(onMulaiButton = { navController.navigate(Halaman.Mahasiswa.name) })

        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiwaFormView (
                onSubmitButtonClickned = {mahasiswaViewModel.saveDataSiswa(it)
                    navController.navigate(
                        Halaman.MataKuliah.name
                    )},
                onBackButtonClickned = {navController.popBackStack()}
            )
        }
