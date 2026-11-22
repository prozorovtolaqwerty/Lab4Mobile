package com.example.izhevsk

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SettingsViewModel(
    private val state: SavedStateHandle,
) : ViewModel() {

    val compactCards: LiveData<Boolean> = state.getLiveData(KEY_COMPACT, false)
    val walkReminder: LiveData<Boolean> = state.getLiveData(KEY_REMINDER, true)

    fun setCompactCards(enabled: Boolean) {
        state[KEY_COMPACT] = enabled
    }

    fun setWalkReminder(enabled: Boolean) {
        state[KEY_REMINDER] = enabled
    }

    companion object {
        private const val KEY_COMPACT = "compact_cards"
        private const val KEY_REMINDER = "walk_reminder"
    }
}
