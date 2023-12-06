package com.example.aston_intensiv_contactsapp

import java.io.Serializable

data class ContactItem(
    val id: Int,
    val name: String,
    val surname: String,
    val phoneNumber: Int,
    val isCheckBoxVisible: Boolean,
    val isChecked: Boolean
): Serializable