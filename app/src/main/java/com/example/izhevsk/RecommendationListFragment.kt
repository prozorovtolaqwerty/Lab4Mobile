package com.example.izhevsk

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecommendationListFragment : Fragment(R.layout.fragment_place_list) {

    private val settingsViewModel: SettingsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = view.findViewById<RecyclerView>(R.id.placeRecycler)
        val adapter = PlaceAdapter(PlaceRepository.placesFor(currentCategoryId())) { place ->
            findNavController().navigate(NavGraphDirections.actionGlobalDetail(place.id))
        }
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
        settingsViewModel.compactCards.observe(viewLifecycleOwner) { compact ->
            adapter.compact = compact
        }
    }

    private fun currentCategoryId(): String {
        return when (findNavController().currentDestination?.id) {
            R.id.restaurantsFragment -> Category.RESTAURANTS
            R.id.parksFragment -> Category.PARKS
            R.id.kidsFragment -> Category.KIDS
            R.id.shoppingFragment -> Category.SHOPPING
            else -> Category.COFFEE
        }
    }
}
