package com.example.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun addMahasiswaDialog(
    state: mahasiswaState,
    onEvent: (mahasiswaEvent) -> Unit,
    modifier: Modifier = Modifier
){
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(mahasiswaEvent.hideDialog)
        },
        title = { Text(text = "Add contact") },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.nama,
                    onValueChange = {
                        onEvent(mahasiswaEvent.setNama(it))
                    },
                    placeholder = {
                        Text(text = "Nama")
                    }
                )
                TextField(
                    value = state.tptLahir,
                    onValueChange = {
                        onEvent(mahasiswaEvent.setTptLahir(it))
                    },
                    placeholder = {
                        Text(text = "Tempat Lahir")
                    }
                )
                TextField(
                    value = state.tglLahir,
                    onValueChange = {
                        onEvent(mahasiswaEvent.setTglLahir(it))
                    },
                    placeholder = {
                        Text(text = "Tanggal Lahir (DD/MM/YY)")
                    }
                )
                TextField(
                    value = state.kelamin,
                    onValueChange = {
                        onEvent(mahasiswaEvent.setKelamin(it))
                    },
                    placeholder = {
                        Text(text = "Jenis Kelamin")
                    }
                )
                TextField(
                    value = state.email,
                    onValueChange = {
                        onEvent(mahasiswaEvent.setEmail(it))
                    },
                    placeholder = {
                        Text(text = "Alamat E-mail")
                    }
                )
                TextField(
                    value = state.phone,
                    onValueChange = {
                        onEvent(mahasiswaEvent.setPhone(it))
                    },
                    placeholder = {
                        Text(text = "Nomor Telepon")
                    }
                )
            }
        },
        buttons = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    onEvent(mahasiswaEvent.saveMhs)
                }) {
                    Text(text = "Save")
                }
            }
        }
    )
}