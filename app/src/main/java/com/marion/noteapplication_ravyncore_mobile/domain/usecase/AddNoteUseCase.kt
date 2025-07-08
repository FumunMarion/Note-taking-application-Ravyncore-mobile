package com.marion.noteapplication_ravyncore_mobile.domain.usecase

import com.marion.noteapplication_ravyncore_mobile.data.Note
import com.marion.noteapplication_ravyncore_mobile.domain.NoteDao
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteDao: NoteDao) {

    suspend operator fun invoke(note: Note) {
        noteDao.insertNote(note)
    }

}