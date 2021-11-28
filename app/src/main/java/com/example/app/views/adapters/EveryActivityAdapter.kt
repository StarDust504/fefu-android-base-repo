package com.example.app.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.EveryActivityData
import com.example.app.views.AbstractCard
import com.example.app.views.viewholders.DateActivityHolder

class EveryActivityAdapter(private val data: List<AbstractCard>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var ItemClickListener: (Int) -> Unit = {}

    companion object {
        private const val ITEM_TYPE_ACTIVITY = 0
        private const val ITEM_TYPE_DATE = 1
    }

    fun setItemClickListener(listener: (Int) -> Unit) {
        ItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE_ACTIVITY -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.users_activity_card, parent, false)
                UsersActivityHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_date_card, parent, false)
                DateActivityHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ITEM_TYPE_ACTIVITY -> {
                (holder as UsersActivityHolder).bind(data[position])
            }
            else -> (holder as DateActivityHolder).bind(data[position])
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is EveryActivityData -> ITEM_TYPE_ACTIVITY
            else -> ITEM_TYPE_DATE
        }
    }

    inner class UsersActivityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivDistance: TextView = itemView.findViewById(R.id.users_activity_card_distance)
        private val ivUsername: TextView = itemView.findViewById(R.id.users_activity_card_username)
        private val ivDuration: TextView = itemView.findViewById(R.id.users_activity_card_duration)
        private val ivType: TextView = itemView.findViewById(R.id.users_activity_card_type)
        private val ivDate: TextView = itemView.findViewById(R.id.users_activity_card_date)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    ItemClickListener.invoke(position)
            }
        }

        fun bind(item: AbstractCard) {
            item as EveryActivityData
            ivDistance.text = item.distance
            ivUsername.text = item.username
            ivDuration.text = item.duration
            ivType.text = item.type
            ivDate.text = item.date
        }
    }
}