package com.example.noteapp2.note_app.domain.use_case
import com.example.noteapp2.note_app.domain.model.Note
import com.example.noteapp2.note_app.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class SearchNotesUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(searchTerm: String): Flow<List<Note>> {
        return repository.searchNotes(searchTerm)
    }
}