package com.tut.mytikunstructure.view.decorated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.tut.mytikunstructure.databinding.DecoratedTextFragmentBinding


class DecoratedTextFragment : Fragment() {

    val clickPositionListener = MutableLiveData<Int>()
    val markRange:MutableLiveData<Pair<Int, Int>> = MutableLiveData<Pair<Int, Int>>()


    lateinit var binding: DecoratedTextFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DecoratedTextFragmentBinding.inflate(layoutInflater, container, false)

        binding.decorativeText.setLiveMark(viewLifecycleOwner, markRange)
        binding.decorativeText.setLiveLongPressIndexListener(clickPositionListener)

        val index1 = binding.decorativeText.text.indexOf("חוחית")
        val index2 = binding.decorativeText.text.indexOf("בז")

        clickPositionListener.observe(viewLifecycleOwner, Observer {
            markRange.value = Pair(it-5, it+5)
        })


        binding.btnScroll.setOnClickListener {
            val line: Int = binding.decorativeText.layout.getLineForOffset(index1)
            val y: Int = binding.decorativeText.layout.getLineTop(line - 3)
            markRange.value = Pair(index1-5, index1+5)
            scroll(y)
        }

        binding.btnScroll2.setOnClickListener {
            val line: Int = binding.decorativeText.layout.getLineForOffset(index2)
            val y: Int = binding.decorativeText.layout.getLineTop(line - 3)
            markRange.value = Pair(index2-5, index2+5)
            scroll(y)
        }

        return binding.root
    }



    fun scroll(y: Int) {
        binding.scollView.post(Runnable {
            binding.scollView.smoothScrollTo(0, y)
        })
    }

}