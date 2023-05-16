package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsScreenViewModel(private val dataStore: DataStore<Preferences>) : ViewModel() {

    private val preferencesState = dataStore.data.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = null)

    private val booleanOptionDesc = "Boolean Option"
    private val booleanOptionKey = booleanPreferencesKey(booleanOptionDesc)
    fun getBooleanOptionDesc() = booleanOptionDesc
    fun getBooleanOptionValue() : Boolean {
        preferencesState.value?.let { preferences ->
            return preferences[booleanOptionKey]?: false
        }
        return false
    }
    fun saveBooleanOptionValue(value: Boolean) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[booleanOptionKey] = value
            }
        }
    }

    private val intOptionDesc = "Int Option"
    private val intOptionKey = intPreferencesKey(intOptionDesc)

    fun getIntOptionDesc() = intOptionDesc
    fun getIntOptionValue() : Int {
        preferencesState.value?.let { preferences ->
            return preferences[intOptionKey]?: 0
        }
        return 0
    }
    fun saveIntOptionValue(value: Int) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[intOptionKey] = value
            }
        }
    }
}