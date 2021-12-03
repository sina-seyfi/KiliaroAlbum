package com.sinaseyfi.kiliaroalbum.utils

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView

// This will make card view square by its width
class SquareGridMaterialCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : MaterialCardView(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

}