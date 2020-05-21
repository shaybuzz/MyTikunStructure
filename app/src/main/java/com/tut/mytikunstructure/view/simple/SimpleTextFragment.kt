package com.tut.mytikunstructure.view.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.tut.mytikunstructure.R
import com.tut.mytikunstructure.databinding.SimpleTextFragmentBinding


class SimpleTextFragment : Fragment() {

    lateinit var binding:SimpleTextFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SimpleTextFragmentBinding.inflate(layoutInflater, container, false)
        val markRange:MutableLiveData<Pair<Int, Int>> = MutableLiveData<Pair<Int, Int>>()

       // val index1 = binding.simpleText.text.indexOf("חוחית")
        //val index2 = binding.simpleText.text.indexOf("בז")

        binding.simpleText.text = resources.getString(R.string.raw_text)
        binding.simpleText.setLiveMark(viewLifecycleOwner, markRange)

        binding.btnScroll.setOnClickListener {
            markRange.value = Pair(250, 260)
        }

        binding.btnScroll2.setOnClickListener {
            markRange.value = Pair(400, 420)
        }




        return binding.root
    }

}