package com.example.noteapp2.note_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteapp2.note_app.presentation.add_edit_note.AddEditNoteScreen
import com.example.noteapp2.note_app.presentation.notes.NotesScreen
import com.example.noteapp2.note_app.presentation.search_notes.SearchNotesScreen
import com.example.noteapp2.note_app.presentation.util.Screen
import com.example.noteapp2.ui.theme.NoteApp2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteApp2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NoteScreen.route,
                    ) {
                        composable(route = Screen.NoteScreen.route) {
                            NotesScreen(navController = navController)
                        }

                        composable(
                            route = Screen.AddEditNoteScreen.route +
                                    "?noteId={noteId}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },

                                )
                        ) {
                            AddEditNoteScreen(navController = navController,)
                        }
                        composable(
                            route = Screen.SearchNotesScreen.route
                        ){
                            SearchNotesScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
