package com.example.noteapp2.note_app.presentation.search_notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp2.note_app.domain.use_case.NoteUseCases
import com.example.noteapp2.note_app.domain.use_case.SearchNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteSearchViewModel @Inject constructor(
    private val notesUseCase:NoteUseCases) : ViewModel() {

    private val _searchState = MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> = _searchState

    fun setSearchQuery(query: String) {
        _searchState.value = _searchState.value.copy(text = query)
        searchNotes()
    }

    private fun searchNotes() {
        viewModelScope.launch {
            notesUseCase.searchNotesUseCase(_searchState.value.text).collect { notes ->
                _searchState.value = _searchState.value.copy(notes = notes)
            }
        }
    }
}

