package com.example.hp.kotlin.NoteApp.database

import android.arch.persistence.room.Room
import android.content.Context

class RoomBuilder {

    companion object {
         var noteDatabase:NoteDatabase?=null

        fun getNoteDatabase(context: Context): NoteDatabase?{
          if(noteDatabase==null){
              synchronized(NoteDatabase::class){
                  noteDatabase = Room.databaseBuilder(context, NoteDatabase::class.java, "noteDB")
                          .allowMainThreadQueries() //temporary, should be done on seperate thread
                          .build();
              }
          }
            return  noteDatabase;
        }
    }


}