package com.example.aston_intensiv_contactsapp

import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class ContactsViewHolder(view: View, ): RecyclerView.ViewHolder(view) {
    val checkbox: CheckBox = view.findViewById(R.id.checkbox)
}