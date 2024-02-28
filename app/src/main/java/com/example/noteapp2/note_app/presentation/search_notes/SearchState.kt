package com.example.noteapp2.note_app.presentation.search_notes

import com.example.noteapp2.note_app.domain.model.Note

data class SearchState(
    val notes: List<Note> = emptyList(),
    val text: String = "",
)