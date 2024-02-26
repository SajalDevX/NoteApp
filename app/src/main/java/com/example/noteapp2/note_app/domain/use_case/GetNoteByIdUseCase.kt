package com.example.noteapp2.note_app.domain.use_case

import com.example.noteapp2.note_app.domain.model.Note
import com.example.noteapp2.note_app.domain.repository.NoteRepository

class GetNoteByIdUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id:Int): Note?{
        return repository.getNoteById(id)
    }
}