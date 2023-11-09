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
import com.example.navigationtask.databinding.FragmentEmailBinding


class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        val name = arguments?.getString("user_name")
        binding.submitBtn.setOnClickListener {
            if(!TextUtils.isEmpty(binding.emailEdt.text.toString())) {
                val bundle = bundleOf("user_email" to binding.emailEdt.text.toString(), "user_name" to name.toString())

                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
            } else {
                Toast.makeText(activity, "Please enter email", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}