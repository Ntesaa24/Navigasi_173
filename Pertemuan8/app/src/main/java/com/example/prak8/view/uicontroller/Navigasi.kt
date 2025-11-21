package com.example.prak8.view.uicontroller

package com.example.belajar1

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prak8.view.TampilData
import com.example.prak8.view.FormIsian

enum class Navigasi {
    tampilan,
    halaman,
    formulir
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = com.example.belajar1.Navigasi.tampilan.name,
            modifier = Modifier.padding(isiRuang)
        ) {

            // --- Halaman Depan ---
            composable(route = com.example.belajar1.Navigasi.tampilan.name) {
                HalamanBeranda (
                    onMasukClick = {
                        // Navigasi ke Halaman Kedua
                        navController.navigate(com.example.belajar1.Navigasi.halaman.name)
                    }
                )
            }

            // --- List Peserta ---
            composable(route = com.example.belajar1.Navigasi.halaman.name) {
                BerandaSelanjutnya (
                    onKeduaClick = {
                        // Kembali ke Tampilan Depan
                        navController.navigate(com.example.belajar1.Navigasi.tampilan.name) {
                            popUpTo(com.example.belajar1.Navigasi.tampilan.name) { inclusive = true }
                        }
                    },
                    onKetigaClick = {
                        // Navigasi ke Formulir Pendaftaran
                        navController.navigate(com.example.belajar1.Navigasi.formulir.name)
                    }
                )
            }

            // --- Form Pendaftaran ---
            composable(route = com.example.belajar1.Navigasi.formulir.name) {
                FormulirPendaftaran(
                    onKetigaClick = {
                        // Kembali ke Halaman Kedua
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

// fungsi untuk kembali ke HalamanDepan
private fun cancelAndBackToBeranda(
    navController: NavHostController
) {
    navController.popBackStack(com.example.belajar1.Navigasi.tampilan.name, inclusive = false)
}
