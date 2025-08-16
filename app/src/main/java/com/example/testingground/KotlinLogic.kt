package com.example.testingground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random


fun main()  {
   val randomDice by mutableIntStateOf((1..6).random())
   println(randomDice)
}


