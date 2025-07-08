package com.marion.noteapplication_ravyncore_mobile.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marion.noteapplication_ravyncore_mobile.domain.NoteDao

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}