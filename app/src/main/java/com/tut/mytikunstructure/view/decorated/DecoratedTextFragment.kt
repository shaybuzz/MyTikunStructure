package com.tut.mytikunstructure.view.decorated

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import com.tut.mytikunstructure.databinding.DecoratedTextFragmentBinding


class DecoratedTextFragment : Fragment() {


    lateinit var binding: DecoratedTextFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DecoratedTextFragmentBinding.inflate(layoutInflater, container, false)


        val index1 = binding.decorativeText.text.indexOf("חוחית")
        val index2 = binding.decorativeText.text.indexOf("בז")


        binding.btnScroll.setOnClickListener {
            val line: Int = binding.decorativeText.layout.getLineForOffset(index1)
            val y: Int = binding.decorativeText.layout.getLineTop(line - 3)
            scroll(y)
        }

        binding.btnScroll2.setOnClickListener {
            val line: Int = binding.decorativeText.layout.getLineForOffset(index2)
            val y: Int = binding.decorativeText.layout.getLineTop(line - 3)
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