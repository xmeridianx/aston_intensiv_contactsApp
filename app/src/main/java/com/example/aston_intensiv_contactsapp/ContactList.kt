package com.example.aston_intensiv_contactsapp

import kotlin.random.Random

object ContactList {
    private var listContacts = (1..10).map {
        ContactItem(it, "Name$it", "LastName$it", Random.nextInt(), false, false)
    }

    fun getContacts(): List<ContactItem> {
        return listContacts
    }

    fun setChecked(contactItem: ContactItem, isChecked: Boolean) {
        listContacts = listContacts.map { item ->
            if (item.id == contactItem.id) {
                item.copy(isChecked = isChecked)
            } else {
                item
            }
        }
    }

    fun getNextId(): Int {
        val maxContactId = listContacts.maxBy { it.id }
        return maxContactId.id.plus(1)
    }

    fun addContact(
        id: Int,
        name: String,
        surname: String,
        phoneNumber: Int,
        isCheckBoxVisible: Boolean,
        isChecked: Boolean
    ) {
        listContacts = listContacts + listOf<ContactItem>(
            ContactItem(
                id,
                name,
                surname,
                phoneNumber,
                isCheckBoxVisible,
                isChecked
            )
        )
    }

    fun editContact(
        id: Int,
        name: String,
        surname: String,
        phoneNumber: Int,
        isCheckBoxVisible: Boolean,
        isChecked: Boolean
    ) {
        listContacts = listContacts.map {
            if (it.id == id) {
                it.copy(
                    name = name,
                    surname = surname,
                    phoneNumber = phoneNumber,
                    isCheckBoxVisible = isCheckBoxVisible,
                    isChecked = isChecked
                )
            } else {
                it
            }
        }.toMutableList()
    }
    fun deleteSelectedContacts() {
        val newList = listContacts.toMutableList()
        newList.removeIf { it.isChecked }
        listContacts = newList
    }

    fun setCheckBoxVisible(isVisible: Boolean){
        listContacts = listContacts.map { it.copy(isCheckBoxVisible = true) }
    }

    fun setCheckBoxInvisible(isVisible: Boolean){
        listContacts = listContacts.map { it.copy(isCheckBoxVisible = false) }
    }
}
