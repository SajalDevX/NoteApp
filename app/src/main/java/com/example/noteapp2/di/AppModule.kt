package com.example.noteapp2.di

import android.app.Application
import androidx.room.Room
import com.example.noteapp2.note_app.data.data_source.NoteDatabase
import com.example.noteapp2.note_app.data.repository.NoteRepositoryImpl
import com.example.noteapp2.note_app.domain.repository.NoteRepository
import com.example.noteapp2.note_app.domain.use_case.AddNoteUseCase
import com.example.noteapp2.note_app.domain.use_case.DeleteNoteUseCase
import com.example.noteapp2.note_app.domain.use_case.GetNoteByIdUseCase
import com.example.noteapp2.note_app.domain.use_case.GetNotesUseCase
import com.example.noteapp2.note_app.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesDatabase(app:Application):NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }
    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDatabase):NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository):NoteUseCases{
        return NoteUseCases(
            getNoteByIdUseCase = GetNoteByIdUseCase(repository),
            getNotesUseCases = GetNotesUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
//            searchNotesUseCase = SearchNotesUseCase(repository)
        )
    }
}