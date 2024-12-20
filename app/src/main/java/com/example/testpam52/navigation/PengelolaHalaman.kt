package com.example.testpam52.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testpam52.ui.view.screen.MahasiwaFormView
import com.example.testpam52.ui.view.screen.RencanaStudyView
import com.example.testpam52.ui.view.screen.SplashView
import com.example.testpam52.ui.view.screen.TampilDataView
import com.example.testpam52.ui.view.viewmodel.MahasiswaViewModel
import com.example.testpam52.ui.view.viewmodel.RencanaStudyViewModel

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
){
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
        composable(route = Halaman.MataKuliah.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {rencanaStudyViewModel.saveDataKRS(it)
                    navController.navigate(
                        Halaman.Tampildata.name){

                    }
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
        composable(route = Halaman.Tampildata.name) {

            TampilDataView(
                mahasiswa = mahasiswaUiState,
                rencanastudy = rencanaStudyState,
                onBackButton = { navController.popBackStack() },
                onSplashButton = {
                    navController.popBackStack(
                        route = Halaman.Splash.name,
                        inclusive = false
                    )
                }
            )
        }
    }
}
