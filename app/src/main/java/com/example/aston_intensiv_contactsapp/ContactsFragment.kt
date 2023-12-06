package com.example.aston_intensiv_contactsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_contactsapp.databinding.FragmentContactsBinding

class ContactsFragment : Fragment(), ContactItemClickListener {

    private lateinit var binding: FragmentContactsBinding
    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        contactsAdapter = ContactsAdapter(this, {contactItem, isChecked ->
            ContactList.setChecked(contactItem, isChecked)
            contactsAdapter.submitList(ContactList.getContacts())
        })
        contactsAdapter.submitList(ContactList.getContacts())
        binding.recyclerViewContactList.adapter = contactsAdapter


        binding.buttonAddContact.setOnClickListener {
            val addContactFragment = CreateContactFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, addContactFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.buttonDelete.setOnClickListener {
            binding.buttonDeleteItem.visibility = View.VISIBLE
            binding.buttonCancel.visibility = View.VISIBLE
            binding.buttonAddContact.visibility = View.INVISIBLE
            binding.buttonDelete.visibility = View.INVISIBLE
            ContactList.setCheckBoxVisible(true)
            contactsAdapter.submitList(ContactList.getContacts())
        }

        binding.buttonDeleteItem.setOnClickListener {
            ContactList.deleteSelectedContacts()
            contactsAdapter.submitList(ContactList.getContacts())
        }
        binding.buttonCancel.setOnClickListener {
            binding.buttonDeleteItem.visibility = View.INVISIBLE
            binding.buttonCancel.visibility = View.INVISIBLE
            binding.buttonAddContact.visibility = View.VISIBLE
            binding.buttonDelete.visibility = View.VISIBLE
            ContactList.setCheckBoxInvisible(true)
            contactsAdapter.submitList(ContactList.getContacts())

        }
    }



    override fun onContactItemClick(contact: ContactItem) {
        val editContactFragment = EditContactFragment()
        val args = Bundle()
        args.putInt("contactId", contact.id)
        editContactFragment.arguments = args

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, editContactFragment)
            .addToBackStack(null)
            .commit()
    }
}