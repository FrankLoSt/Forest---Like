package com.example.testingground

import android.R
import android.R.attr.color
import android.R.attr.onClick
import android.graphics.Color.alpha
import android.graphics.Paint
import android.graphics.fonts.FontStyle
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropModifierNode
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.testingground.ui.theme.TestingGroundTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.format.TextStyle
import kotlin.math.log


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingGroundTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Project101()
                }
            }
        }
    }
}
/*
* Input: Current selected mood and callback for when a new mood is selected.
Output: UI for clickable mood options.
* */
@Composable
fun Project101() {
    var countDown by remember { mutableIntStateOf(10) }
    var isStart by remember { mutableStateOf(false) }
    var minutes = countDown / 60
    var seconds = countDown % 60
    var formatted = String.format("%02d:%02d", minutes, seconds)
    LaunchedEffect(isStart) {
        if (isStart) {
            while (countDown > 0) {
                delay(1000)
                countDown--
            }
            delay(200)
            isStart = false
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF41B3A3)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (countDown == 0) {
            Text("\uD83C\uDF33 You've planted a tree successfully", 
                color = Color.White)
        }
        Box(
            modifier = Modifier
                .size(width = 250.dp, height = 300.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFFE8A87C), shape = CircleShape)
                    .size(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .size(245.dp)
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEEE2DC)),
                    shape = CircleShape,
                    elevation = CardDefaults.cardElevation(9.dp)
                ) {
                    Box() {
                        Canvas(modifier = Modifier.size(250.dp).padding(16.dp)) {
                            val canvasWidth = size.width
                            val canvasHeight = size.height
                            // Arc size (a wide and tall oval)
                            val arcWidth = canvasWidth * 0.95f
                            val arcHeight = canvasHeight * 0.2f
                            // Position arc at the BOTTOM of the canvas
                            val arcLeft = (canvasWidth - arcWidth) / 2f
                            val arcTop = canvasHeight * 0.6f
                            val arcSize = Size(arcWidth, arcHeight)
                            drawArc(
                                color = Color(0xFF5D3A1A),
                                startAngle = 0f,     // Starts from the left
                                sweepAngle = 180f,     // Sweeps to the right
                                useCenter = true,      // Connects to center to form a filled shape
                                topLeft = Offset(arcLeft, arcTop * 0.54f),
                                size = Size(arcWidth, arcHeight * 3.5f)
                            )
                            drawOval(
                                color = Color(0xFFA0522D),
                                topLeft = Offset(arcLeft, arcTop),
                                size = Size(arcWidth, arcHeight - 25f),
                                style = Fill
                            )
                            // Half circle centered horizontally over the oval
                        }
                        val isTimerFinished by remember { mutableStateOf(false) }

                        if (isStart) {
                            Text(
                                text = "🌱",
                                fontSize = 40.sp,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        } else {

                            Text("🌳", fontSize = 100.sp, modifier = Modifier.offset(48.dp, 37.dp))
                        }
                    }
                }

        }
    }

        Text(
            if (isStart) formatted else "00:10",
            fontSize = 90.sp,
            color = Color.White,
            modifier = Modifier
        )
        Button(
            onClick = {
                if (!isStart) {
                    isStart = true
                    countDown = 10
                } else {
                    isStart = false
                    countDown = 10
                }
            }
        ) {
            Text(if (isStart) "Give up" else "Start")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingGroundTheme {
        Project101()
    }
}
