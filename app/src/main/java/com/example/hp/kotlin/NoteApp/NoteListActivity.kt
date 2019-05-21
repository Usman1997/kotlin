package com.example.hp.kotlin.NoteApp

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.hp.kotlin.NoteApp.adapters.NoteAdapter
import com.example.hp.kotlin.NoteApp.database.NoteDao
import com.example.hp.kotlin.NoteApp.database.NoteDatabase
import com.example.hp.kotlin.NoteApp.database.RoomBuilder
import com.example.hp.kotlin.NoteApp.models.Note
import com.example.hp.kotlin.R
import com.example.hp.kotlin.R.id.noteListRecyclerView
import com.google.gson.Gson
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

       setData();

    }

    override fun onResume() {
        super.onResume()
        setData()

    }

    fun setData(){
        noteList = noteDao!!.getAllNote() as ArrayList<Note>
        adapter = NoteAdapter(noteList,this)
        noteListRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        noteListRecyclerView.adapter = adapter
    }
    override fun editNote(note: Note) {
        var intent = Intent(this,AddNoteActivity::class.java);
        var gson = Gson();
        var json = gson.toJson(note)
        intent.putExtra("note",json)
        startActivity(intent)
    }

    override fun deleteNote(note: Note) {
        adapter!!.remove(note)

    }

    fun buAdd(view:View){
        var intent = Intent(this,AddNoteActivity::class.java);
        startActivity(intent)
    }

}