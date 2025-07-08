package com.marion.noteapplication_ravyncore_mobile.di

import android.content.Context
import androidx.room.Room
import com.marion.noteapplication_ravyncore_mobile.data.NotesDatabase
import com.marion.noteapplication_ravyncore_mobile.domain.NoteDao
import com.marion.noteapplication_ravyncore_mobile.domain.usecase.AddNoteUseCase
import com.marion.noteapplication_ravyncore_mobile.domain.usecase.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesDatabase(@ApplicationContext context: Context): NotesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            klass = NotesDatabase::class.java,
            name = "notes_database"
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(database: NotesDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    @Singleton
    fun provideInsertNoteUseCase(noteDao: NoteDao) =
        AddNoteUseCase(noteDao)

    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(noteDao: NoteDao) =
        GetNotesUseCase(noteDao)

}