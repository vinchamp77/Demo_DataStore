package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vtsen.hashnode.dev.datastoredemoapp.ProtoPreferences

class ViewModelFactory<K>(
    private val dataStore: DataStore<K>,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(PrefsDataStoreScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PrefsDataStoreScreenViewModel(
                dataStore as DataStore<Preferences>
            ) as T
        }
        else if (modelClass.isAssignableFrom(ProtoDataStoreScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProtoDataStoreScreenViewModel(
                dataStore as DataStore<ProtoPreferences>
            ) as T
        }


        throw IllegalArgumentException("Unknown ViewModel class")
    }
}