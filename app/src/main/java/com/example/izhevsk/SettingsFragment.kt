package com.example.izhevsk

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.materialswitch.MaterialSwitch

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val settingsViewModel: SettingsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val compactSwitch = view.findViewById<MaterialSwitch>(R.id.compactSwitch)
        val reminderSwitch = view.findViewById<MaterialSwitch>(R.id.reminderSwitch)

        settingsViewModel.compactCards.observe(viewLifecycleOwner) { enabled ->
            if (compactSwitch.isChecked != enabled) {
                compactSwitch.isChecked = enabled
            }
        }
        settingsViewModel.walkReminder.observe(viewLifecycleOwner) { enabled ->
            if (reminderSwitch.isChecked != enabled) {
                reminderSwitch.isChecked = enabled
            }
        }
        compactSwitch.setOnCheckedChangeListener { _, checked ->
            settingsViewModel.setCompactCards(checked)
        }
        reminderSwitch.setOnCheckedChangeListener { _, checked ->
            settingsViewModel.setWalkReminder(checked)
        }
    }
}
