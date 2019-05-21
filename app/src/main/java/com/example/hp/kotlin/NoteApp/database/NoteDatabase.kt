package com.example.hp.kotlin.NoteApp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.hp.kotlin.NoteApp.models.Note


@Database(entities = [Note::class],version = 1)
abstract class NoteDatabase: RoomDatabase() {


     abstract fun getNoteDao():NoteDao
}
