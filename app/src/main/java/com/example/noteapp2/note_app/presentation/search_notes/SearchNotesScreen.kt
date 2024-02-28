package com.example.noteapp2.note_app.presentation.search_notes


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.noteapp2.note_app.domain.util.NotesEvent
import com.example.noteapp2.note_app.presentation.notes.NotesViewModel
import com.example.noteapp2.note_app.presentation.notes.components.NoteItem
import com.example.noteapp2.note_app.presentation.util.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchNotesScreen(
    navController: NavController,
    viewModel: NoteSearchViewModel = hiltViewModel(),
    addEditNoteViewModel: NotesViewModel = hiltViewModel()
) {
    val searchState by viewModel.searchState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(8.dp),
                title = {},
                actions = {
                    OutlinedTextField(
                        value = searchState.text,
                        onValueChange = { viewModel.setSearchQuery(it) },
                        label = { Text("Search") },
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp, top = 72.dp, end = 16.dp)
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn{
                items(searchState.notes) { note ->
                    NoteItem(
                        note = note,
                        modifier= Modifier
                            .padding(bottom = 16.dp)
                            .clickable(
                                onClick = {
                                    navController.navigate(
                                        Screen.AddEditNoteScreen.route +
                                                "?noteId=${note.id}"
                                    )
                                }
                            ),
                        onDeleteClick = {
                            addEditNoteViewModel.onEvent(NotesEvent.DeleteNote(note))
                        }

                    )
                }
            }
        }
    }
}


