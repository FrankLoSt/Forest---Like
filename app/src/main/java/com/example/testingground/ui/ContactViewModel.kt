package com.example.testingground.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



// ViewModel
class ContactViewModel(): ViewModel() {

    var randomDice by mutableIntStateOf((1..6).random())

    fun rollDice() {
        randomDice = (1..6).random()
    }
}






private fun Unit.launchIn(viewModelScope: CoroutineScope) {}
