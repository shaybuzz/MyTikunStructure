package com.tut.mytikunstructure.view.simple

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tut.mytikunstructure.databinding.SimpleTextFragmentBinding
import kotlinx.android.synthetic.main.simple_text_fragment.*


class SimpleTextFragment : Fragment() {

    lateinit var binding:SimpleTextFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SimpleTextFragmentBinding.inflate(layoutInflater, container, false)

        binding.simpleText.setMovementMethod(ScrollingMovementMethod())
        val index1 = binding.simpleText.text.indexOf("חוחית")
        val index2 = binding.simpleText.text.indexOf("בז")






        binding.btnScroll.setOnClickListener {
            val line: Int = binding.simpleText.getLayout().getLineForOffset(index1)
            val y: Int = binding.simpleText.getLayout().getLineTop(line)
            scroll(y)
        }

        binding.btnScroll2.setOnClickListener {
            val line: Int = binding.simpleText.getLayout().getLineForOffset(index2)
            val y: Int = binding.simpleText.getLayout().getLineTop(line)
            scroll(y)

        }

        return binding.root
    }

    fun scroll(y:Int){
        binding.simpleText.post(Runnable {
            binding.simpleText.scrollTo(0, y)
        })
    }
}