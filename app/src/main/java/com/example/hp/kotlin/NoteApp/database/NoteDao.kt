package com.example.hp.kotlin.NoteApp.database

import android.arch.persistence.room.*
import com.example.hp.kotlin.NoteApp.models.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note);

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNote(): List<Note>

    @Query("SELECT * FROM notes WHERE id==:id")
    fun getSingleNote(id: Int): Note
}