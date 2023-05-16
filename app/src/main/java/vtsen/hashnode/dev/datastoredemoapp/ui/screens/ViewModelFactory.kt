package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(
    private val dataStore: DataStore<Preferences>,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SettingsScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsScreenViewModel(
                dataStore
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}