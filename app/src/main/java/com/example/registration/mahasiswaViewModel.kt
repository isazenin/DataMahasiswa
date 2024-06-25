package com.example.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class mahasiswaViewModel(private val dao: mahasiswaDao): ViewModel() {
    val _state = MutableStateFlow(mahasiswaState())
    fun onEvent(event: mahasiswaEvent){
        when(event){
            is mahasiswaEvent.deleteMhs -> {
                viewModelScope.launch {
                    dao.deleteMhs(event.Mahasiswa)
                }
            }
            mahasiswaEvent.hideDialog -> {
                _state.update { it.copy(
                    isAddingMhs = false
                ) }
            }
            mahasiswaEvent.saveMhs -> {
                val nama = _state.value.nama
                val tptLahir = _state.value.tptLahir
                val tglLahir = _state.value.tglLahir
                val kelamin = _state.value.kelamin
                val email = _state.value.email
                val phone = _state.value.phone

                if(nama.isBlank() || tptLahir.isBlank() || kelamin.isBlank() || email.isBlank() || phone.isBlank() || tglLahir.isBlank()){
                    return
                }
                val Mahasiswa = mahasiswa(
                    nama = nama,
                    tptLahir = tptLahir,
                    tglLahir = tglLahir,
                    kelamin = kelamin,
                    email = email,
                    phone = phone
                )
                viewModelScope.launch {
                    dao.upsertMhs(Mahasiswa)
                }
                _state.update { it.copy(
                    isAddingMhs = false,
                    nama = "",
                    tptLahir = "",
                    tglLahir = "",
                    kelamin = "",
                    email = "",
                    phone = ""
                ) }
            }
            is mahasiswaEvent.setEmail -> {
                _state.update { it.copy(
                    email = event.email
                ) }
            }
            is mahasiswaEvent.setKelamin -> {
                _state.update { it.copy(
                    kelamin = event.kelamin
                ) }
            }
            is mahasiswaEvent.setNama -> {
                _state.update { it.copy(
                    nama = event.nama
                ) }
            }
            is mahasiswaEvent.setPhone -> {
                _state.update { it.copy(
                    phone = event.phone
                ) }
            }
            is mahasiswaEvent.setTglLahir -> {
                _state.update { it.copy(
                    tglLahir = event.tglLahir
                ) }
            }
            is mahasiswaEvent.setTptLahir -> {
                _state.update { it.copy(
                    tptLahir = event.tptLahir
                ) }
            }
            mahasiswaEvent.showDialog -> {
                _state.update { it.copy(
                    isAddingMhs = true
                ) }
            }
        }
    }
}