package com.example.lifecyclescope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.withCreated
import androidx.lifecycle.withResumed
import androidx.lifecycle.withStarted
import androidx.navigation.fragment.findNavController
import com.example.lifecyclescope.databinding.FragmentFirstBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        lifecycleScope.launch(Dispatchers.Main){
            delay(4000)
            binding.progress.visibility = View.GONE
            delay(5000)
            binding.progress.visibility = View.VISIBLE


            // sometimes we may need to suspend the execution of codeBlock considering the current state of lifecycle object, for that we have three additional builders
            withCreated {
                Log.d("Tag", "Created")
            } // this Coroutine is launched when activity or fragment is created for the first Time.
            withStarted {
                Log.d("Tag", "Started")
            } // this coroutine is launched when activity/fragment is started
            withResumed {
                Log.d("Tag", "Resumed")
            } // this coroutine is launched when activity/fragment has started an used by user.
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}