package com.example.hp.kotlin.NoteApp.database

import android.arch.persistence.room.*
import com.example.hp.kotlin.NoteApp.models.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note);

    @Query("UPDATE notes SET title = :title, description= :description WHERE id =:id")
    fun update(title: String, description: String, id: Int)


    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNote(): List<Note>

    @Query("SELECT * FROM notes WHERE id==:id")
    fun getSingleNote(id: Int): Note
}