package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import vtsen.hashnode.dev.datastoredemoapp.ui.theme.DataStoreDemoAppTheme

@Composable
fun MainScreen() {

    var showUserSettings by remember { mutableStateOf(false) }

    if(showUserSettings) {
        SettingsScreen(doneCallback = {showUserSettings = false})
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showUserSettings = true}) {
                Text(text = "Preferences DataStore")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DataStoreDemoAppTheme(useSystemUIController = false) {
        MainScreen()
    }
}