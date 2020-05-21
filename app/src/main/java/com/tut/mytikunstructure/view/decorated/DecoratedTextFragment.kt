package com.tut.mytikunstructure.view.decorated

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.view.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import com.tut.mytikunstructure.R
import com.tut.mytikunstructure.databinding.DecoratedTextFragmentBinding


class DecoratedTextFragment : Fragment() {

    lateinit var spannableString:SpannableString
    lateinit var backgroundSpan:BackgroundColorSpan
    val fontSizeSpan = RelativeSizeSpan(1.4f)

    lateinit var binding: DecoratedTextFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DecoratedTextFragmentBinding.inflate(layoutInflater, container, false)

        spannableString= SpannableString(resources.getString(R.string.raw_text))
        backgroundSpan = BackgroundColorSpan(resources.getColor(R.color.textBackgroundColor))

        binding.decorativeText.text = spannableString
        val index1 = binding.decorativeText.text.indexOf("חוחית")
        val index2 = binding.decorativeText.text.indexOf("בז")




        binding.btnScroll.setOnClickListener {
            val line: Int = binding.decorativeText.layout.getLineForOffset(index1)
            val y: Int = binding.decorativeText.layout.getLineTop(line - 3)
            markText(index1, index1+5)
            scroll(y)
        }

        binding.btnScroll2.setOnClickListener {
            val line: Int = binding.decorativeText.layout.getLineForOffset(index2)
            val y: Int = binding.decorativeText.layout.getLineTop(line - 3)
            markText(index2, index2+5)
            scroll(y)
        }



        return binding.root
    }

    fun markText(start:Int, end:Int){
        spannableString.removeSpan(backgroundSpan)
        spannableString.removeSpan(fontSizeSpan)
        spannableString.setSpan(backgroundSpan, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(fontSizeSpan, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        binding.decorativeText.text = spannableString
    }


    fun scroll(y: Int) {
        binding.scollView.post(Runnable {
            binding.scollView.smoothScrollTo(0, y)
        })
    }

}