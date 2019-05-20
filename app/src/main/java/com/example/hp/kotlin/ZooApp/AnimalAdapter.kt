package com.example.hp.kotlin.ZooApp

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import com.example.hp.kotlin.R
import kotlinx.android.synthetic.main.animal_killer_ticket.view.*

class AnimalAdapter(val animalList: ArrayList<Animal>) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AnimalAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.getContext()).inflate(R.layout.animal_ticket, p0, false);
        return ViewHolder(view);
    }


    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val animal = animalList[p1]
        p0.bindItem(animal)

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(animal: Animal) {
            itemView.tvDes.text = animal.des
            itemView.tvName.text = animal.name
        }
    }

    override fun getItemCount(): Int {
        return animalList.size
    }


}