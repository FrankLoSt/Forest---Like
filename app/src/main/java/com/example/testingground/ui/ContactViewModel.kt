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
    var countDown by mutableIntStateOf(10) //countdown number
        private set
    var isStart by mutableStateOf(false) // start or give up
        private set
    private var countdownJob: Job? = null // Job - controller
    fun countdownSwitcher () {
        isStart = !isStart
        if(!isStart) {
            countdownJob?.cancel()
            countDown = 10
            message = "😢 You gave up. Try again!"
        }
    }
    val formatted: String
        get() = String.format("%02d:%02d", countDown / 60, countDown % 60) //displayed string
    var isDone by mutableStateOf(false) //check de bat Dialog
        private set
    fun changeIsDone () {
        isDone = !isDone
    }
    var message by mutableStateOf("")
        private set

    init {
        viewModelScope.launch{
            snapshotFlow { isStart } //snapshotFlow turns a mutable state into a flow
                .collect { started -> //collect collects emitted values once at a time
                    if(started) {
                        countdownJob = launch { //create a Job
                            while(countDown > 0) {
                                delay(1000)
                                countDown--
                            }
                            if(countDown == 0 ) {
                                isDone = true
                                isStart = false
                                countDown = 10
                                message = "🌳 You've successfully planted a tree!"
                            }

                        }
                    }
                }
        }
    }
}





private fun Unit.launchIn(viewModelScope: CoroutineScope) {}
