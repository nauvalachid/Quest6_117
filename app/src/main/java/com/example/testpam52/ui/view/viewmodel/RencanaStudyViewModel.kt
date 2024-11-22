package com.example.testpam52.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testpam52.model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel() {
    private val _krsState = MutableStateFlow(RencanaStudy())
    val krsStateUi: StateFlow<RencanaStudy> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String) {
        _krsState.update { it.copy(namaMK = mkPilihan) }
    }

    fun setKelas(kelasPilihan: String) {
        _krsState.update { it.copy(kelas = kelasPilihan) }
    }

    fun saveDataKRS(ls: MutableList<String>) {
        _krsState.update { it.copy(
            namaMK = ls[0],
            kelas = ls[1]
        )}
    }
}