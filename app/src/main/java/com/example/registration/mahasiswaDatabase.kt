package com.example.registration

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [mahasiswa::class],
    version = 1
)
abstract class mahasiswaDatabase: RoomDatabase() {
    abstract val dao: mahasiswaDao
}