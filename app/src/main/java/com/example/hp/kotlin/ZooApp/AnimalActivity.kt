package com.example.hp.kotlin.ZooApp

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import com.example.hp.kotlin.R
import kotlinx.android.synthetic.main.activity_animal.*
import kotlinx.android.synthetic.main.animal_killer_ticket.view.*
import java.util.ArrayList

class AnimalActivity:AppCompatActivity() {

  var animalList = ArrayList<Animal>()
    var adapter:AnimalAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)

        animalList.add(Animal("cat","This is cat",R.mipmap.ic_launcher,false))
        animalList.add(Animal("dog","This is dog",R.mipmap.ic_launcher,false))
        animalList.add(Animal("tiger","This is tiger",R.mipmap.ic_launcher,true))
        animalList.add(Animal("lion","This is lion",R.mipmap.ic_launcher,true))
        adapter = AnimalAdapter(animalList)
        tvListAnimal.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        tvListAnimal.adapter = adapter

    }

//    inner class AnimalAdapter: BaseAdapter{
//
//        var animatList = ArrayList<Animal>();
//        var context:Context?=null;
//
//        constructor(context: Context,animalList: ArrayList<Animal>):super(){
//            this.animatList = animalList;
//            this.context = context;
//        }
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//           val animal = animalList[position]
//            if(animal.isKiller==true){
//               var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//                var view  = inflater.inflate(R.layout.animal_killer_ticket,null)
//
//                view.tvDes.text = animal.des;
//                view.tvName.text = animal.name;
//                view.ivAnimalImage.setImageResource(animal.image!!)
//                return view;
//
//
//            }else{
//                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//                var view  = inflater.inflate(R.layout.animal_ticket,null)
//                view.tvDes.text = animal.des;
//                view.tvName.text = animal.name;
//                view.ivAnimalImage.setImageResource(animal.image!!)
//                return view;
//
//            }
//
//        }
//
//        override fun getItem(position: Int): Any {
//       return animatList[position]
//               }
//
//        override fun getItemId(position: Int): Long {
//            return position.toLong()
//        }
//
//        override fun getCount(): Int {
//        return animatList.size
//        }
//
//    }
}