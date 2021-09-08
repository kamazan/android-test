package com.evaneos.destinations_list.presentation.ui.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.evaneos.common.presentation.ui.recyclerview.viewholder.ItemViewHolder
import com.evaneos.destinations_list.presentation.model.DestinationItem
import com.evaneos.destinations_list.presentation.model.DestinationItem.DestinationCardItem

class DestinationAdapter(private val onAction: ((View, DestinationItem) -> Unit)?) :
    ListAdapter<DestinationItem, ItemViewHolder<DestinationItem>>(DiffCallback()) {

    override fun onBindViewHolder(holder: ItemViewHolder<DestinationItem>, position: Int) {
        holder.bind(getItem(position), onAction)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<DestinationItem> {
        return when (DestinationItem.Type.values()[viewType]) {
            DestinationItem.Type.DESTINATION_CARD -> DestinationCardItemViewHolder.create(parent)
            DestinationItem.Type.EMPTY_MESSAGE -> DestinationEmptyViewHolder.create(parent)
        } as ItemViewHolder<DestinationItem>
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.ordinal
    }

    private class DiffCallback : DiffUtil.ItemCallback<DestinationItem>() {
        override fun areContentsTheSame(oldItem: DestinationItem, newItem: DestinationItem): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: DestinationItem, newItem: DestinationItem): Boolean {
            return when {
                oldItem is DestinationCardItem && newItem is DestinationCardItem -> {
                    oldItem.destination.id == newItem.destination.id
                }
                else -> oldItem == newItem
            }
        }
    }
}