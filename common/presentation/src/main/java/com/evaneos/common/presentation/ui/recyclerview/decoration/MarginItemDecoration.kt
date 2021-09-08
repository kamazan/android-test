package com.evaneos.common.presentation.ui.recyclerview.decoration

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    resources: Resources,
    @DimenRes height: Int? = null,
    @DimenRes width: Int? = null,
) :
    RecyclerView.ItemDecoration() {

    private val verticalMargin: Int = height?.run { resources.getDimension(this).toInt() } ?: 0
    private val horizontalMargin: Int = width?.run { resources.getDimension(this).toInt() } ?: 0

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.top = verticalMargin
        }
        outRect.bottom = verticalMargin
        outRect.left = horizontalMargin
        outRect.right = horizontalMargin
    }
}