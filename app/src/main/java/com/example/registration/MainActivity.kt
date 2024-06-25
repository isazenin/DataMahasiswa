package com.plcoding.roomguideandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.registration.mahasiswaDatabase
import com.example.registration.mahasiswaScreen
import com.example.registration.mahasiswaViewModel
import com.example.registration.ui.theme.RegistrationTheme

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            mahasiswaDatabase::class.java,
            "siswa.db"
        ).build()
    }
    private val viewModel by viewModels<mahasiswaViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return mahasiswaViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistrationTheme {
                val state by viewModel._state.collectAsState()
                mahasiswaScreen(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}