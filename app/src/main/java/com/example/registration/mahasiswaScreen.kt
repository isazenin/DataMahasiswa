package com.example.registration

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun mahasiswaScreen(
    state: mahasiswaState,
    onEvent: (mahasiswaEvent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(mahasiswaEvent.showDialog)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Data Baru"
                )
            }
        }
    ) { _ ->
        if (state.isAddingMhs) {
            addMahasiswaDialog(state = state, onEvent = onEvent)
        }
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                        verticalAlignment = Alignment.CenterVertically
                ){}
            }
            items(state.mahasiswa) { Mahasiswa ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "${Mahasiswa.nama}",
                            fontSize = 20.sp
                        )
                        Text(text = "${Mahasiswa.tptLahir} ${Mahasiswa.tglLahir}", fontSize = 12.sp)
                        Text(text = Mahasiswa.kelamin, fontSize = 12.sp)
                        Text(text = Mahasiswa.email, fontSize = 12.sp)
                        Text(text = Mahasiswa.phone, fontSize = 12.sp)
                    }
                    IconButton(onClick = {
                        onEvent(mahasiswaEvent.deleteMhs(Mahasiswa))
                    }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Hapus Data Mahasiswa"
                        )
                    }
                }
            }
        }
    }
}