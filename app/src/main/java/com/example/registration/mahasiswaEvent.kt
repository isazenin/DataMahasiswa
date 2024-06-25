package com.example.registration

import androidx.room.PrimaryKey
import java.sql.Date

sealed interface mahasiswaEvent {
    object saveMhs: mahasiswaEvent
    data class setNama(val nama: String): mahasiswaEvent
    data class setTptLahir(val tptLahir: String): mahasiswaEvent
    data class setTglLahir(val tglLahir: String): mahasiswaEvent
    data class setKelamin(val kelamin: String): mahasiswaEvent
    data class setEmail(val email: String): mahasiswaEvent
    data class setPhone(val phone: String): mahasiswaEvent
    object showDialog: mahasiswaEvent
    object hideDialog: mahasiswaEvent
    data class deleteMhs(val Mahasiswa: mahasiswa): mahasiswaEvent
}