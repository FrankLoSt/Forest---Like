package com.example.testingground

import ads_mobile_sdk.vi
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewModelScope
import com.example.testingground.ui.ContactViewModel
import com.example.testingground.ui.theme.TestingGroundTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import androidx.compose.ui.res.stringResource



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
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
            Image(
                painter = painterResource(R.drawable.bg_compose_background),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.jetpack_compose_tutorial),
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(R.string.jetpack_compose_is_a_modern_toolkit_for_building_native_android_ui_compose_simplifies_and_accelerates_ui_development_on_android_with_less_code_powerful_tools_and_intuitive_kotlin_apis),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp),
                textAlign = TextAlign.Justify
            )
           Text(
                text = stringResource(R.string.in_this_tutorial_you_build_a_simple_ui_component_with_declarative_functions_you_call_compose_functions_to_say_what_elements_you_want_and_the_compose_compiler_does_the_rest_compose_is_built_around_composable_functions_these_functions_let_you_define_your_app_s_ui_programmatically_because_they_let_you_describe_how_it_should_look_and_provide_data_dependencies_rather_than_focus_on_the_process_of_the_ui_s_construction_such_as_initializing_an_element_and_then_attaching_it_to_a_parent_to_create_a_composable_function_you_add_the_composable_annotation_to_the_function_name),
               modifier = Modifier.padding(16.dp),
               textAlign = TextAlign.Justify
           )

    }
}



    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TestingGroundTheme {
            Project101()
        }
    }




