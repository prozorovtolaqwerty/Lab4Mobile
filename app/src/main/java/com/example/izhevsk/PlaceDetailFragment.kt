package com.example.izhevsk

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class PlaceDetailFragment : Fragment(R.layout.fragment_place_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val placeId = PlaceDetailFragmentArgs.fromBundle(requireArguments()).placeId
        val place = PlaceRepository.find(placeId) ?: return
        view.findViewById<ImageView>(R.id.detailIcon).apply {
            setImageResource(place.iconRes)
            contentDescription = getString(place.nameRes)
        }
        view.findViewById<TextView>(R.id.detailName).setText(place.nameRes)
        view.findViewById<TextView>(R.id.detailBody).setText(place.detailRes)
        (activity as? AppCompatActivity)?.supportActionBar?.title = getString(place.nameRes)
    }
}
