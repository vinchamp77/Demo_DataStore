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

    var showPrefsDataStoreScreen by remember { mutableStateOf(false) }
    var showProtoDataStoreScreen by remember { mutableStateOf(false) }

    if(showPrefsDataStoreScreen) {
        PrefsDataStoreScreen(doneCallback = {showPrefsDataStoreScreen = false})

    } else if(showProtoDataStoreScreen) {
        ProtoDataStoreScreen(doneCallback = {showProtoDataStoreScreen = false})

    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showPrefsDataStoreScreen = true}) {
                Text(text = "Preferences DataStore")
            }

            Button(onClick = { showProtoDataStoreScreen = true}) {
                Text(text = "Proto DataStore")
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