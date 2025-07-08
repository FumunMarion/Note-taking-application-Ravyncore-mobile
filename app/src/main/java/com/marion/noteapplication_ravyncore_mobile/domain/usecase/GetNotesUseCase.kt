package com.marion.noteapplication_ravyncore_mobile.domain.usecase

import com.marion.noteapplication_ravyncore_mobile.domain.NoteDao
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val noteDao: NoteDao) {

    operator fun invoke() = noteDao.getAllNotes()
}