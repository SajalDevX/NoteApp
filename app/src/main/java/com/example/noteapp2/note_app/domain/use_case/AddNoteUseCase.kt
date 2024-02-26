package com.example.noteapp2.note_app.domain.use_case

import com.example.noteapp2.note_app.domain.model.InvalidNoteException
import com.example.noteapp2.note_app.domain.model.Note
import com.example.noteapp2.note_app.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("The Title of note can't be empty")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of not can't be empty")
        }
        repository.insertNote(note)
    }
}