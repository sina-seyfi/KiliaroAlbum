package com.sinaseyfi.kiliaroalbum.ui.album

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import com.sinaseyfi.kiliaroalbum.R
import kotlin.math.roundToInt

class GridItemDecoration(
    val context: Context,
    val spanCount: Int,
    @DimenRes val dimen: Int = R.dimen.grid_items_margin,
    val insetStartAndEnd: Boolean = true
): RecyclerView.ItemDecoration() {

    private val itemsMargin = context.resources.getDimension(dimen)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view)
        val startColumn = index % spanCount == 0
        val endColumn = (index + 1) % spanCount == 0
        val startRow = index < spanCount
        val leftOffset = if(startColumn) { if(insetStartAndEnd) itemsMargin else 0f } else itemsMargin / 2f
//        val leftOffset = if(startColumn) itemsMargin else itemsMargin / 2 + if(endColumn) itemsMargin / 2 else 0
        val rightOffset = if(endColumn) { if(insetStartAndEnd) itemsMargin else 0f } else itemsMargin / 2f
//        val rightOffset = if(endColumn) itemsMargin else itemsMargin / 2 + if(startColumn) itemsMargin / 2 else 0
        val topOffset = if(startRow) 0f else itemsMargin
        outRect.set(
            leftOffset.roundToInt(),
            topOffset.roundToInt(),
            rightOffset.roundToInt(),
            0
        )
    }

}