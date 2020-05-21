package com.tut.mytikunstructure.view.customview

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.RelativeSizeSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.tut.mytikunstructure.R

open class MarkableTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    var spannableString: SpannableString? = null
    var backgroundSpan: BackgroundColorSpan
    //val fontSizeSpan = RelativeSizeSpan(1.2f)   // not sure if looking good

    init {
        backgroundSpan = BackgroundColorSpan(resources.getColor(R.color.textBackgroundColor))
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        spannableString = SpannableString(text)
        super.setText(spannableString, type)
    }

    fun setLiveMark(lifecycleOwner: LifecycleOwner, mark: LiveData<Pair<Int, Int>?>?){
        mark?.observe(lifecycleOwner, Observer {
            it?.let {range->
                if(range.first == -1 && range.second == -1) {
                    clearMark()
                }else{
                    markText(range.first, range.second)
                }
            }
        })
    }

    fun clearMark(){
        spannableString?.removeSpan(backgroundSpan)
        //spannableString?.removeSpan(fontSizeSpan)
    }

    fun markText(start: Int, end: Int) {
        if(start < 0 || end < 0 || start >= text.length || end >= text.length || start >= end) return

        spannableString?.removeSpan(backgroundSpan)
        //spannableString?.removeSpan(fontSizeSpan)
        spannableString?.setSpan(backgroundSpan, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
       //spannableString?.setSpan(fontSizeSpan, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        text = spannableString
    }


}
