package com.example.noteapp2.note_app.presentation.notes

import com.example.noteapp2.note_app.domain.model.Note
import com.example.noteapp2.note_app.domain.util.NoteOrder
import com.example.noteapp2.note_app.domain.util.OrderType

data class NotesState (
    val notes:List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean = false
)