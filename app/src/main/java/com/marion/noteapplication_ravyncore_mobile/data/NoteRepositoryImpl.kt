package com.marion.noteapplication_ravyncore_mobile.data

import com.marion.noteapplication_ravyncore_mobile.domain.NoteRepository
import com.marion.noteapplication_ravyncore_mobile.domain.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteRepository: NoteRepository) : NoteDao {
    override suspend fun insertNote(note: Note) {
        noteRepository.insertNote(note)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }

}