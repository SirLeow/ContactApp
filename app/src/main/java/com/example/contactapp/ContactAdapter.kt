package com.example.contactapp

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val lista: MutableList<Contact> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ContactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
}