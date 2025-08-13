package com.example.testingground

import ads_mobile_sdk.vi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewModelScope
import com.example.testingground.ui.ContactViewModel
import com.example.testingground.ui.theme.TestingGroundTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ContactViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingGroundTheme {
                Project101()
                    }
                }
            }
        }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project101() {
    val viewModel1: ContactViewModel = viewModel()
    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF41B3A3)),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (viewModel1.message.isNotEmpty()) {
            Text(
                viewModel1.message,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
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

                        if (viewModel1.isStart) {
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
            if (viewModel1.isStart) viewModel1.formatted else "00:10",
        fontSize = 90.sp,
        color = Color.White,
        modifier = Modifier
        )
        Button(
            onClick = { viewModel1.countdownSwitcher() }
        ) {
            Text(if (viewModel1.isStart) "Give up" else "Start")
        }

//but how to integrate the logic into my code?
    }
    if (viewModel1.isDone) {
        Dialog(onDismissRequest = { viewModel1.changeIsDone() }) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                tonalElevation = 8.dp,
                modifier = Modifier.padding(16.dp).size(250.dp, 250.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Horray!",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black
                    )

                    Spacer(Modifier.height(15.dp))

                    Text(
                        "You've earned 15 stars",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )

                    Spacer(Modifier.height(24.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFffc000),
                            modifier = Modifier.size(25.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFffc000),
                            modifier = Modifier.size(45.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFffc000),
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { viewModel1.changeIsDone() },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF60cb1a))
                    ) {
                        Text("OK")
                    }
                }
            }
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




