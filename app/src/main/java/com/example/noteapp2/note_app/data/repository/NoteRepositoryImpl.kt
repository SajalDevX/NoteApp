package com.example.noteapp2.note_app.data.repository

import android.provider.ContactsContract
import com.example.noteapp2.note_app.data.data_source.NoteDao
import com.example.noteapp2.note_app.domain.model.Note
import com.example.noteapp2.note_app.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override suspend fun searchNotes(searchTerm: String): Flow<List<Note>> {
        return dao.searchNotes(searchTerm)
    }
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}