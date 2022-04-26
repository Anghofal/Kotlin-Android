package com.example.cukurin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class adapterBarber (private val arrayList: ArrayList<arrayListAdapter>) :
        RecyclerView.Adapter<adapterBarber.ViewHolder>(){
    class ViewHolder (view:View) :RecyclerView.ViewHolder(view){
        val namaBarber: TextView
        val deksBarber: TextView
        val layoutadapter:CardView

        init {
            namaBarber = view.findViewById(R.id.namaBarber)
            deksBarber = view.findViewById(R.id.deksBarber)
            layoutadapter = view.findViewById(R.id.layoutAdapter)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterBarber.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: adapterBarber.ViewHolder, position: Int) {
        val arr = arrayList[position]
        holder.namaBarber.text = arr.nama
        holder.deksBarber.text = arr.dekskripsi

        holder.layoutadapter.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                val it = Intent(view.context,pesan::class.java)
                it.putExtra("nama",arr.nama)
                it.putExtra("deks",arr.dekskripsi)
                view.context.startActivity(it)
            }
        })

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

}

class arrayListAdapter(nama:String, dekskripsi: String){
    var nama = nama
    get() = field
    var dekskripsi = dekskripsi
    get() = field
}