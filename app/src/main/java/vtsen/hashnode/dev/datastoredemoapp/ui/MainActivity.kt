package vtsen.hashnode.dev.datastoredemoapp.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import vtsen.hashnode.dev.datastoredemoapp.ProtoPreferences
import vtsen.hashnode.dev.datastoredemoapp.data.ProtoPreferencesSerializer
import vtsen.hashnode.dev.datastoredemoapp.ui.screens.MainScreen
import vtsen.hashnode.dev.datastoredemoapp.ui.theme.DataStoreDemoAppTheme

val Context.prefsDataStore by preferencesDataStore(name = "settings")

val Context.protoDataStore: DataStore<ProtoPreferences> by dataStore(
    fileName = "UserPreferences.pb",
    serializer = ProtoPreferencesSerializer
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setupSplashScreen()

        super.onCreate(savedInstanceState)

        setContent {
            DataStoreDemoAppTheme {
                MainScreen()
            }
        }
    }

    private fun setupSplashScreen() {
        var keepSplashScreenOn = true
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                delay(2000)
                keepSplashScreenOn = false
            }
        }

        installSplashScreen().setKeepOnScreenCondition {
            keepSplashScreenOn
        }
    }
}
