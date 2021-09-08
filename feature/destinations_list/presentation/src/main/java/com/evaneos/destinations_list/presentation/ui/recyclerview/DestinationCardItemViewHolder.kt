package com.evaneos.destinations_list.presentation.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.evaneos.common.presentation.ui.recyclerview.viewholder.ItemViewHolder
import com.evaneos.common.presentation.utils.extension.textOrInvisible
import com.evaneos.destinations_list.databinding.DestinationListItemBinding
import com.evaneos.destinations_list.presentation.model.DestinationItem.DestinationCardItem

class DestinationCardItemViewHolder private constructor(private val binding: DestinationListItemBinding) :
    ItemViewHolder<DestinationCardItem>(binding.root) {

    override fun bind(item: DestinationCardItem, onAction: ((View, DestinationCardItem) -> Unit)?) {
        with(binding) {
            root.setOnClickListener { view -> onAction?.invoke(view, item) }

            with(destinationItemImage) {
                load(item.destination.pictureUrl)
            }

            destinationItemTextName.text = item.destination.name
            destinationItemRating.rating = item.destination.rating
            destinationItemTextTag.textOrInvisible(item.destination.tag)
        }
    }

    companion object {
        fun create(parent: ViewGroup): DestinationCardItemViewHolder {
            val binding = DestinationListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return DestinationCardItemViewHolder(binding)
        }
    }
}