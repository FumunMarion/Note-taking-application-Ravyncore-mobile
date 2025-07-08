package com.marion.noteapplication_ravyncore_mobile.domain.usecase

import com.marion.noteapplication_ravyncore_mobile.data.NoteRepositoryImpl
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val noteRepositoryImpl: NoteRepositoryImpl) {

    operator fun invoke() = noteRepositoryImpl.getAllNotes()
}