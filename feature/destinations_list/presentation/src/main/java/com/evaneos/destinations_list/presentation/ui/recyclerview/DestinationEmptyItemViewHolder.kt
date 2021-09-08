package com.evaneos.destinations_list.presentation.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evaneos.common.presentation.ui.recyclerview.viewholder.ItemViewHolder
import com.evaneos.destinations_list.databinding.DestinationEmptyMessageListItemBinding
import com.evaneos.destinations_list.presentation.model.DestinationItem.DestinationEmptyMessageItem

class DestinationEmptyViewHolder private constructor(private val binding: DestinationEmptyMessageListItemBinding) :
    ItemViewHolder<DestinationEmptyMessageItem>(binding.root) {

    override fun bind(
        item: DestinationEmptyMessageItem,
        onAction: ((View, DestinationEmptyMessageItem) -> Unit)?
    ) {
        binding.destinationItemTextEmptyButton.setOnClickListener { view ->
            onAction?.invoke(view, item)
        }
    }

    companion object {
        fun create(parent: ViewGroup): DestinationEmptyViewHolder {
            val binding = DestinationEmptyMessageListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return DestinationEmptyViewHolder(binding)
        }
    }
}
