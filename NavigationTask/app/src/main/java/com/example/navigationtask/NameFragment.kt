package com.example.navigationtask

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationtask.databinding.FragmentNameBinding


class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        binding.moveToEmailBtn.setOnClickListener{
            val bundle = bundleOf("user_name" to binding.nameEdt.text.toString())
            if(TextUtils.isEmpty(binding.nameEdt.text.toString())) {
                Toast.makeText(activity, "Please enter name", Toast.LENGTH_SHORT).show()
            } else {
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle)
            }
        }
        return binding.root
    }
}