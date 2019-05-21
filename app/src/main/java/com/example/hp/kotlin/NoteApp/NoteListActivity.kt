package com.example.hp.kotlin.NoteApp

import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.example.hp.kotlin.NoteApp.adapters.NoteAdapter
import com.example.hp.kotlin.NoteApp.database.NoteDao
import com.example.hp.kotlin.NoteApp.database.NoteDatabase
import com.example.hp.kotlin.NoteApp.database.RoomBuilder
import com.example.hp.kotlin.NoteApp.models.Note
import com.example.hp.kotlin.R
import com.example.hp.kotlin.R.id.noteListRecyclerView
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity :AppCompatActivity(),NoteAdapter.ButtonCallBackInterface {

    var noteList = ArrayList<Note>()
    var adapter:NoteAdapter?=null
    private var db: NoteDatabase?=null
    private var noteDao: NoteDao?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        db = RoomBuilder.getNoteDatabase(this);
        noteDao = db?.getNoteDao();

        noteList = noteDao!!.getAllNote() as ArrayList<Note>

        adapter = NoteAdapter(noteList,this)
        noteListRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        noteListRecyclerView.adapter = adapter

    }

    override fun editNote(note: Note) {
     Toast.makeText(this,"Edit",Toast.LENGTH_LONG).show()
    }

    override fun deleteNote(note: Note) {
        Toast.makeText(this,"Delete",Toast.LENGTH_LONG).show()

    }

}