package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(
    private val dataStore: DataStore<Preferences>,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(PrefsDataStoreScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PrefsDataStoreScreenViewModel(
                dataStore
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}