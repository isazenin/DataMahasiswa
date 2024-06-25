package com.example.registration

data class mahasiswaState(
    val mahasiswa: List<mahasiswa> = emptyList(),
    val nama: String = "",
    val tptLahir: String = "",
    val tglLahir: String = "",
    val kelamin: String = "",
    val email: String = "",
    val phone: String = "",
    val isAddingMhs: Boolean = false
)
