package com.example.hp.kotlin.NoteApp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hp.kotlin.NoteApp.models.Note
import com.example.hp.kotlin.R
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter(val noteList:ArrayList<Note>,val buttonCallBackInterface: ButtonCallBackInterface): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.note_item,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(p0: NoteAdapter.ViewHolder, p1: Int) {
        val note = noteList[p1]
        p0.bindItem(note,buttonCallBackInterface)

    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindItem(note: Note,buttonCallBackInterface: ButtonCallBackInterface) {
            itemView.evTitle.text = note.title
            itemView.evDes.text = note.description
            itemView.evEdit.setOnClickListener {
               buttonCallBackInterface.editNote(note)
            }

            itemView.evDelete.setOnClickListener {
                buttonCallBackInterface.deleteNote(note)
            }
        }
    }

    fun getItem(position:Int):Note{
        return noteList[position]
    }

    fun remove(note:Note){
        val position = noteList.indexOf(note)
        if(position>-1){
            noteList.removeAt(position)
            notifyItemRemoved(position)
        }
    }


    interface ButtonCallBackInterface{
        fun editNote(note:Note)
        fun deleteNote(note:Note)
    }

}