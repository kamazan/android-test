package com.evaneos.common.presentation.ui.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ItemViewHolder<T>(containerView: View) : RecyclerView.ViewHolder(containerView) {
    abstract fun bind(item: T, onAction: ((View, T) -> Unit)? = null)
}