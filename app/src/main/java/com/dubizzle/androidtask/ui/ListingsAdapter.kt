package com.dubizzle.androidtask.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dubizzle.androidtask.R
import com.dubizzle.androidtask.databinding.ItemHomeBinding
import com.dubizzle.presentation.model.Listings

class ListingsAdapter
    : ListAdapter<Listings, ListingsAdapter.ListViewHolder>(ListingsDiffUtil()) {

    var interaction: Interaction? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) =
        ListViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), interaction
        )

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

    fun swapData(data: List<Listings>) {
        submitList(data.toMutableList())
    }

    inner class ListViewHolder(
        private val binding: ItemHomeBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val clicked = getItem(adapterPosition)
            interaction?.listingsClicked(clicked)
        }

        fun bind(item: Listings) {

            binding.name.text = item.name
            val media = item.imageUrlsThumbnails?.get(0)
            if (media !== null) {
                Glide.with(binding.root)
                    .load(media)
                    .into(binding.thumbnail)
            } else {
                binding.thumbnail.setImageResource(R.drawable.ic_launcher_background)
            }

        }
    }

    interface Interaction {
        fun listingsClicked(
            Object: Listings
        )
    }

    private class ListingsDiffUtil : DiffUtil.ItemCallback<Listings>() {
        override fun areItemsTheSame(oldItem: Listings, newItem: Listings) =
            oldItem.uid == newItem.uid

        override fun areContentsTheSame(oldItem: Listings, newItem: Listings) = oldItem == newItem
    }
}