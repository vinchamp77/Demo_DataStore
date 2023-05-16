package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsScreenViewModel(private val dataStore: DataStore<Preferences>) : ViewModel() {

    private val booleanOptionName = "Boolean Option"
    private val booleanOptionKey = booleanPreferencesKey(booleanOptionName)

    val booleanOptionState = dataStore.data.map { preferences ->
            preferences[booleanOptionKey] ?: false
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = false
        )

    fun getBooleanOptionName() = booleanOptionName
    fun saveBooleanOptionValue(value: Boolean) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[booleanOptionKey] = value
            }
        }
    }

    private val intOptionName = "Int Option"
    private val intOptionKey = intPreferencesKey(intOptionName)

    val intOptionState = dataStore.data.map { preferences ->
        preferences[intOptionKey] ?: 0
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = 0
    )

    fun getIntOptionName() = intOptionName
    fun saveIntOptionValue(value: Int) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[intOptionKey] = value
            }
        }
    }
}