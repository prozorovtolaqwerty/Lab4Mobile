package com.example.izhevsk

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceViewHolder(
    itemView: View,
    private val onPlaceClick: (Place) -> Unit,
) : RecyclerView.ViewHolder(itemView) {

    private val placeIcon: ImageView = itemView.findViewById(R.id.placeIcon)
    private val placeName: TextView = itemView.findViewById(R.id.placeName)
    private val placeSummary: TextView = itemView.findViewById(R.id.placeSummary)
    private var currentPlace: Place? = null

    init {
        itemView.setOnClickListener {
            currentPlace?.let(onPlaceClick)
        }
    }

    fun bind(place: Place, compact: Boolean) {
        currentPlace = place
        val context = itemView.context
        placeName.setText(place.nameRes)
        placeSummary.setText(place.summaryRes)
        placeSummary.maxLines = if (compact) 1 else 2
        placeIcon.setImageResource(place.iconRes)
        placeIcon.contentDescription = context.getString(place.nameRes)
    }
}
