package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel

private val Context.dataStore by preferencesDataStore(name = "settings")


class SettingsScreenViewModel(private val dataStore: DataStore<Preferences>) : ViewModel() {
}