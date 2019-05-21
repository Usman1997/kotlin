package com.example.hp.kotlin.NoteApp.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.jetbrains.annotations.Contract


@Entity(tableName = "notes")
class Note {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id:Int?=null;
    @ColumnInfo(name="title")
    var title:String?=null;
    @ColumnInfo(name="description")
    var description:String?=null;

    constructor(title:String,description:String){
        this.title = title;
        this.description  = description;
    }




}