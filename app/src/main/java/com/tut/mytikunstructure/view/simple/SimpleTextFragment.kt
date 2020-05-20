package com.tut.mytikunstructure.view.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tut.mytikunstructure.databinding.SimpleTextFragmentBinding


class SimpleTextFragment : Fragment() {

    lateinit var binding:SimpleTextFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SimpleTextFragmentBinding.inflate(layoutInflater, container, false)

        val index1 = binding.simpleText.text.indexOf("חוחית")
        val index2 = binding.simpleText.text.indexOf("בז")




        return binding.root
    }

}