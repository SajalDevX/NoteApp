package com.example.noteapp2.note_app.domain.use_case

import com.example.noteapp2.note_app.domain.model.Note
import com.example.noteapp2.note_app.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}