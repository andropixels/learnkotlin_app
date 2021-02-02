package com.rahul.learnkotlin.Adapter

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.rahul.learnkotlin.DataClass.programDataClass
import com.rahul.learnkotlin.Fragments.Program
import com.rahul.learnkotlin.Fragments.Theorey
import com.rahul.learnkotlin.R
import com.rahul.learnkotlin.individualactivity.IndividualActivity

class programAdapter(var context: Context, val list:MutableList<programDataClass>): RecyclerView.Adapter<programAdapter.ProgramViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.proframitem,parent,false)
        return ProgramViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size

    }


    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val pos=list[position]
           holder.text.text=pos.A



       holder. relativelayout!!.setOnClickListener {

            val intent=Intent(context,IndividualActivity::class.java)
            it?.context?.startActivity(intent)
           val  pref=context.getSharedPreferences("pref",MODE_PRIVATE).edit()
           pref.putInt("key",pos.id!!).apply()



        }



    }




    class ProgramViewHolder(Itemview: View): RecyclerView.ViewHolder(Itemview){

        val text=itemView.findViewById<TextView>(R.id.textprogram)
        val relativelayout=itemView.findViewById<RelativeLayout>(R.id.RL)



    }
}