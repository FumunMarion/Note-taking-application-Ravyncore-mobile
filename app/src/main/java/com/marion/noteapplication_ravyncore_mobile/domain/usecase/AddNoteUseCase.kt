package com.marion.noteapplication_ravyncore_mobile.domain.usecase

import com.marion.noteapplication_ravyncore_mobile.data.Note
import com.marion.noteapplication_ravyncore_mobile.data.NoteRepositoryImpl
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepositoryImpl: NoteRepositoryImpl) {

    suspend operator fun invoke(note: Note) {
        noteRepositoryImpl.insertNote(note)
    }

}