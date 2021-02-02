package com.rahul.learnkotlin.individualactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.core.Tag
import com.google.firebase.database.ktx.getValue
import com.rahul.learnkotlin.DataClass.programDataClass
import com.rahul.learnkotlin.R
import me.biubiubiu.justifytext.library.JustifyTextView

class IndividualActivity : AppCompatActivity() {

    private var id:Int?=null
    lateinit var  text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual)
        text=findViewById(R.id.textt)
        val pref = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE).also {
            id= it.getInt("key",0)
        }
        val ref=FirebaseDatabase.getInstance().getReference().child("program")
        ref.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                  for (snap in snapshot.children){
                      val data=snap.getValue(programDataClass::class.java)
                      if (id==data?.id) {
                          text.setText(data?.para)
                      }
                  }

            }


        })


    }
}