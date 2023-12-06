package com.example.aston_intensiv_contactsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.aston_intensiv_contactsapp.databinding.FragmentCreateContactBinding


class CreateContactFragment : Fragment() {
    private lateinit var binding: FragmentCreateContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateContactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSaveContact.setOnClickListener {
            if (
                binding.editTextName.text.toString().isNotEmpty() &&
                binding.editTextSurname.text.toString().isNotEmpty() &&
                binding.editTextPhoneNumber.text.toString().isNotEmpty()
            ) {
                ContactList.addContact(
                    ContactList.getNextId(),
                    binding.editTextName.text.toString(),
                    binding.editTextSurname.text.toString(),
                    binding.editTextPhoneNumber.text.toString().toInt(),
                    false,
                    false
                )
                requireActivity().supportFragmentManager.popBackStack()
            }else{
                Toast.makeText(requireContext(), "нужно заполнить все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
