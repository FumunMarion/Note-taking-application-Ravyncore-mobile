package com.marion.noteapplication_ravyncore_mobile.domain.repository

import com.marion.noteapplication_ravyncore_mobile.data.Note
import com.marion.noteapplication_ravyncore_mobile.domain.room.NoteDao
import com.marion.noteapplication_ravyncore_mobile.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteDaoImpl @Inject constructor(private val noteRepository: NoteRepository) : NoteDao {
    override suspend fun insertNote(note: Note) {
        noteRepository.insertNote(note)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }

}