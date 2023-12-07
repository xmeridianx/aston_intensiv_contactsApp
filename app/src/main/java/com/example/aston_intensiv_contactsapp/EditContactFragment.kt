package com.example.aston_intensiv_contactsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.aston_intensiv_contactsapp.databinding.FragmentEditContactBinding

class EditContactFragment : Fragment() {

    private lateinit var binding: FragmentEditContactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditContactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactId = arguments?.getInt("contactId", 0)

        binding.buttonSaveContact.setOnClickListener {
            if (
                binding.editTextName.text.toString().isNotEmpty() &&
                binding.editTextSurname.text.toString().isNotEmpty() &&
                binding.editTextPhoneNumber.text.toString().isNotEmpty()
            ) {
                val newName = binding.editTextName.text.toString()
                val newSurname = binding.editTextSurname.text.toString()
                val newPhoneNumber = binding.editTextPhoneNumber.text.toString()

                ContactList.editContact(contactId!!, newName, newSurname, newPhoneNumber, false, false)

                requireActivity().supportFragmentManager.popBackStack()
            }else{
                Toast.makeText(requireContext(), "нужно заполнить все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}