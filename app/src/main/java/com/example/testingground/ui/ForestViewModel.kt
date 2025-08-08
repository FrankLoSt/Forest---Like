package com.example.testingground.ui

import kotlinx.coroutines.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.*

class ForestViewModel: ViewModel() {

    var countDown by mutableStateOf(10) //how many seconds left
        private set

    var isStart by mutableStateOf(false)  //isStart variable
        private set

    fun startTimer() {
        if (isStart) return
        isStart = true
        countDown = 10

        viewModelScope.launch {
            while (countDown > 0 && isStart) {
                delay(1000)
                countDown--
            }
            isStart = false
        }
    }// this is the countDown logic

    fun stopTimer() { //dont get this part
        isStart = false
        countDown = 10
    }
}