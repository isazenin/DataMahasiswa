package com.example.registration

import android.provider.ContactsContract.CommonDataKinds.Email
import java.sql.Date
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class mahasiswa(
    val nama: String,
    val tptLahir: String,
    val tglLahir: String,
    val kelamin: String,
    val email: String,
    val phone: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
