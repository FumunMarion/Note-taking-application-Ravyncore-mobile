package com.marion.noteapplication_ravyncore_mobile.domain.repository

import com.marion.noteapplication_ravyncore_mobile.data.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(note: Note)

    fun getAllNotes(): Flow<List<Note>>
}