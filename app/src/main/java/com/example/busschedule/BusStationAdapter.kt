package com.example.busschedule

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.busschedule.database.Schedule
import com.example.busschedule.databinding.BusStationItemBinding
import com.example.busschedule.util.DateFormatter

class BusStationAdapter(
    private val onItemClicked: (Schedule) -> Unit,
    private val dateFormatter: DateFormatter
) :
    ListAdapter<Schedule, BusStationAdapter.BusStationViewHolder>(DiffCallback) {
    class BusStationViewHolder(private var binding: BusStationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(schedule: Schedule, dateFormatter: DateFormatter) {
            binding.stopNameTextView.text = schedule.stationName
            binding.arrivalTimeTextView.text = dateFormatter.getFormat(schedule.arrivalTime)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BusStationViewHolder {
        val viewHolder = BusStationViewHolder(
            BusStationItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: BusStationViewHolder, position: Int) {
        holder.bind(getItem(position), dateFormatter)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem == newItem
            }
        }
    }
}