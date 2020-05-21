package com.tut.mytikunstructure.view.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.tut.mytikunstructure.R
import com.tut.mytikunstructure.databinding.SimpleTextFragmentBinding


class SimpleTextFragment : Fragment() {

    lateinit var binding:SimpleTextFragmentBinding
    val clickPositionListener = MutableLiveData<Int>()
    val markRange:MutableLiveData<Pair<Int, Int>> = MutableLiveData<Pair<Int, Int>>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SimpleTextFragmentBinding.inflate(layoutInflater, container, false)

        binding.simpleText.setLiveMark(viewLifecycleOwner, markRange)
        binding.simpleText.setLiveLongPressIndexListener(clickPositionListener)


        clickPositionListener.observe(viewLifecycleOwner, Observer {
            markRange.value = Pair(it-5, it+5)
        })

        binding.btnScroll.setOnClickListener {
            markRange.value = Pair(250, 260)
        }

        binding.btnScroll2.setOnClickListener {
            markRange.value = Pair(400, 420)
        }




        return binding.root
    }

}