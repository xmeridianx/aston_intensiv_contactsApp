package com.example.aston_intensiv_contactsapp

import android.view.LayoutInflater
import androidx.recyclerview.widget.ListAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContactsAdapter(
    private val onContactItemClick: (ContactItem) -> Unit,
    private val onCheckChange:(ContactItem, Boolean) -> Unit
): ListAdapter<ContactItem,ContactsViewHolder>(ContactsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contact = getItem(position)

        holder.itemView.findViewById<TextView>(R.id.textViewId).text = contact.id.toString()
        holder.itemView.findViewById<TextView>(R.id.textViewName).text = contact.name
        holder.itemView.findViewById<TextView>(R.id.textViewSurename).text = contact.surname
        holder.itemView.findViewById<TextView>(R.id.textViePhoneNumber).text = contact.phoneNumber

        holder.itemView.setOnClickListener {
            onContactItemClick(contact)
        }
        holder.checkbox.setOnCheckedChangeListener(null)
        holder.checkbox.isChecked = contact.isChecked

        if (contact.isCheckBoxVisible){
            holder.checkbox.visibility = View.VISIBLE
        }else{
            holder.checkbox.visibility = View.INVISIBLE
        }

        holder.checkbox.setOnCheckedChangeListener { compoundButton, isChecked ->
            onCheckChange(contact, isChecked)
        }
    }
}