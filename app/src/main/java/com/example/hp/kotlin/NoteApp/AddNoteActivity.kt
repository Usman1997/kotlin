package com.example.hp.kotlin.NoteApp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.hp.kotlin.NoteApp.database.NoteDao
import com.example.hp.kotlin.NoteApp.database.NoteDatabase
import com.example.hp.kotlin.NoteApp.database.RoomBuilder
import com.example.hp.kotlin.NoteApp.models.Note
import com.example.hp.kotlin.R
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity:AppCompatActivity() {

    private var db:NoteDatabase?=null
    private var noteDao:NoteDao?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note);
    }

    fun buAdd(view:View){
         var title = evTitle.text.toString()
        var description = evDescription.text.toString()

        if(title.equals("")){
            Toast.makeText(this,"Please enter title",Toast.LENGTH_LONG).show()
        }else if(description.equals("")) {
            Toast.makeText(this, "Please enter description", Toast.LENGTH_LONG).show()
        }else{
            var note = Note(title,description)
            db = RoomBuilder.getNoteDatabase(this);
            noteDao = db?.getNoteDao();

            noteDao?.insert(note)
            Toast.makeText(this,"Note Added Successfully",Toast.LENGTH_LONG).show()

        }
    }
}