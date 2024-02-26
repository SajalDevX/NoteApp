package com.example.noteapp2.note_app.domain.util

import com.example.noteapp2.note_app.domain.model.Note

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder):NotesEvent()
    data class DeleteNote(val note: Note):NotesEvent()
    object ToggleOrderSection:NotesEvent()
}