package com.example.registration

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert

@Dao
interface mahasiswaDao {
    @Upsert
    suspend fun upsertMhs(Mahasiswa: mahasiswa)
    @Delete
    suspend fun deleteMhs(Mahasiswa: mahasiswa)
}