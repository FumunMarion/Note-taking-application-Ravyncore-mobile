package com.marion.noteapplication_ravyncore_mobile.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldUtil(
    navController: NavController,
    isNavIconVisible: Boolean,
    title: String,
    content: @Composable (PaddingValues) -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation = 7.dp),
                title = {
                    Text(text = title, fontSize = 18.sp, color = Black)
                },
                navigationIcon = {
                    if (isNavIconVisible)
                        IconButton(
                            onClick = {
                                navController.navigateUp()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = "Back icon",
                                tint = Black,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    else {
                        Unit
                    }
                }
            )
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}