package com.example.noteapp2.note_app.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteapp2.note_app.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note ")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Query("SELECT * FROM note WHERE title LIKE :searchTermFirstChar || '%' OR content LIKE :searchTermFirstChar || '%'")
    fun searchNotes(searchTermFirstChar: String): Flow<List<Note>>


    @Delete
    suspend fun deleteNote(note:Note)
}