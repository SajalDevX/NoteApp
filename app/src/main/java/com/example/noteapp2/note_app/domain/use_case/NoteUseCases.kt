package com.example.noteapp2.note_app.domain.use_case

data class NoteUseCases(
    val getNotesUseCases: GetNotesUseCase,
    val getNoteByIdUseCase: GetNoteByIdUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
)