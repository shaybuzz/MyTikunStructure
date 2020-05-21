package com.tut.mytikunstructure.view.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import androidx.lifecycle.MutableLiveData

class MarkableTouchableTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MarkableTextView(context, attrs, defStyleAttr) {

    private var gestureDetector: GestureDetectorCompat
    private var longPressOnIndex: MutableLiveData<Int>? = null

    init {
        gestureDetector =
            GestureDetectorCompat(context, object : GestureDetector.OnGestureListener {
                override fun onShowPress(e: MotionEvent?) {
                }

                override fun onSingleTapUp(e: MotionEvent?): Boolean {
                    return false
                }

                override fun onDown(e: MotionEvent?): Boolean {
                    return true
                }

                override fun onFling(
                    e1: MotionEvent?,
                    e2: MotionEvent?,
                    velocityX: Float,
                    velocityY: Float
                ): Boolean {
                    return false
                }

                override fun onScroll(
                    e1: MotionEvent?,
                    e2: MotionEvent?,
                    distanceX: Float,
                    distanceY: Float
                ): Boolean {
                    return false
                }

                override fun onLongPress(event: MotionEvent?) {
                    event?.let {
                        val index = touchIndex(it.x, it.y)
                        Log.d("####", "##### index $index")
                        longPressOnIndex?.value = index
                    }
                }
            })

        setOnTouchListener { v, event ->
            if (gestureDetector.onTouchEvent(event)) {
                true
            } else {
                false
            }
        }
    }

    fun setLiveLongPressIndexListener(alongPressOnIndex: MutableLiveData<Int>) {
        longPressOnIndex = alongPressOnIndex
    }

    private fun touchIndex(x: Float, y: Float): Int {
        val line: Int = layout.getLineForVertical(y.toInt())
        val offset: Int = layout.getOffsetForHorizontal(line, x)
        return offset
    }


}
