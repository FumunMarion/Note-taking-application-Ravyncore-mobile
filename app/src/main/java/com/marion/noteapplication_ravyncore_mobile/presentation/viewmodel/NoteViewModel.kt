package com.marion.noteapplication_ravyncore_mobile.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marion.noteapplication_ravyncore_mobile.data.Note
import com.marion.noteapplication_ravyncore_mobile.domain.usecase.AddNoteUseCase
import com.marion.noteapplication_ravyncore_mobile.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    getNotesUseCase: GetNotesUseCase
) : ViewModel() {

    val notesState: StateFlow<List<Note>> = getNotesUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }
}