package com.tut.mytikunstructure.view.decorated

import android.R.attr
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tut.mytikunstructure.databinding.DecoratedTextFragmentBinding


class DecoratedTextFragment:Fragment() {

    lateinit var binding:DecoratedTextFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DecoratedTextFragmentBinding.inflate(layoutInflater, container, false)

        val index1 = binding.decorativeText.text.indexOf("חוחית")
        val index2 = binding.decorativeText.text.indexOf("בז")

        binding.decorativeText.setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN ->{
                    val index = touchIndex(event.x, event.y)
                    Log.d("####", "##### index $index")
                }
            }
            false
        }



        binding.btnScroll.setOnClickListener {
            val line: Int = binding.decorativeText.layout.getLineForOffset(index1)
            val y: Int = binding.decorativeText.layout.getLineTop(line-3)
            scroll(y)
        }

        binding.btnScroll2.setOnClickListener {
            val line: Int = binding.decorativeText.layout.getLineForOffset(index2)
            val y: Int = binding.decorativeText.layout.getLineTop(line-3)
            scroll(y)
        }



        return binding.root
    }


    fun scroll(y:Int){
        binding.scollView.post(Runnable {
            binding.scollView.smoothScrollTo(0, y)
        })
    }

    fun touchIndex( x:Float,  y:Float):Int{
        val line: Int = binding.decorativeText.layout.getLineForVertical(y.toInt())
        val offset: Int = binding.decorativeText.layout.getOffsetForHorizontal(line, x)
        return offset
    }
}