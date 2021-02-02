package com.rahul.learnkotlin.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rahul.learnkotlin.Adapter.programAdapter
import com.rahul.learnkotlin.DataClass.programDataClass
import com.rahul.learnkotlin.R

class Program : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter:programAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        lateinit  var datalist:MutableList<programDataClass>
        val inflate = inflater.inflate(R.layout.fragment_program, container, false)
            recyclerView=inflate.findViewById(R.id.programrecycler)
            datalist= arrayListOf()
        adapter= programAdapter(context!!,datalist)

        val  ref= FirebaseDatabase.getInstance().getReference().child("program")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
             }

            override fun onDataChange(snapshot: DataSnapshot) {

                for (snap in snapshot.children){
                    val data=snap.getValue(programDataClass::class.java)
                    datalist.add(data!!)

                }

                recyclerView.layoutManager=LinearLayoutManager(activity as Context)
                adapter=programAdapter(context!!,datalist )
                recyclerView.adapter=adapter
                adapter.notifyDataSetChanged()
            }
        })
        return inflate

    }

}