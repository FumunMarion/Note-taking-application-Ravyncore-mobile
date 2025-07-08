package com.marion.noteapplication_ravyncore_mobile.navhost

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marion.noteapplication_ravyncore_mobile.presentation.MyNotesScreen
import com.marion.noteapplication_ravyncore_mobile.presentation.NoteInputScreen
import com.marion.noteapplication_ravyncore_mobile.presentation.viewmodel.NoteViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val noteViewModel = hiltViewModel<NoteViewModel>()

    NavHost(navController, startDestination = "NotesListScreen") {
        composable(route = "NotesListScreen") {
            MyNotesScreen(
                navController,
                noteViewModel
            )
        }
        composable(route = "AddNoteScreen") {
            NoteInputScreen(
                navController,
                noteViewModel,
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}