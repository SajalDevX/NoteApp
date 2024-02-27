//package com.example.noteapp2.note_app.presentation.search_notes
//
//import SearchViewModel
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//
//@Composable
//fun SearchNotesScreen(
//    navController: NavController,
//    viewModel: SearchViewModel = hiltViewModel()
//) {
//    val searchText by viewModel.searchText.collectAsState()
//    val persons by viewModel.notes.collectAsState()
//    val isSearching by viewModel.isSearching.collectAsState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        TextField(
//            value = searchText,
//            onValueChange = { viewModel.takeUserInput(text = it) },
//            modifier = Modifier.fillMaxWidth(),
//            placeholder = { Text(text = "Search") },
//            singleLine = true
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        if (isSearching) {
//            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                CircularProgressIndicator()
//            }
//        } else {
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f)
//            ) {
//                items(persons) { notes ->
//                    Text(
//                        text = notes.title,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 16.dp)
//                    )
//                }
//            }
//        }
//    }
//}
