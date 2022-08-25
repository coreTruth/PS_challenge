package com.app.platformscience.presentation.driver

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.platformscience.data.entity.Driver
import com.app.platformscience.databinding.DriverItemLayoutBinding


class DriverAdapter(private val onClickClb: (Driver) -> Unit) :
    ListAdapter<Driver, DriverAdapter.VH>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH.create(parent)

    override fun onBindViewHolder(holder: VH, position: Int) {
        val driver = getItem(position)
        holder.bind(driver)
        holder.itemView.setOnClickListener {
            onClickClb.invoke(driver)
        }
    }

    class VH(private val driverItemBinding: DriverItemLayoutBinding) :
        RecyclerView.ViewHolder(driverItemBinding.root) {

        companion object {
            fun create(parent: ViewGroup): VH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DriverItemLayoutBinding.inflate(layoutInflater, parent, false)
                return VH(binding)
            }

        }

        fun bind(driver: Driver) {
            driverItemBinding.textDriverName.text = driver.name
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Driver>() {
        override fun areItemsTheSame(oldItem: Driver, newItem: Driver) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Driver, newItem: Driver) =
            oldItem == newItem
    }
}


