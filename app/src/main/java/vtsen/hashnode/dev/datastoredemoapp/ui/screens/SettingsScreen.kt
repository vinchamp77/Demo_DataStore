package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import vtsen.hashnode.dev.datastoredemoapp.ui.dataStore

@Composable
fun SettingsScreen(doneCallback: ()->Unit) {

    val viewModel: SettingsScreenViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current.dataStore)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(viewModel.getBooleanOptionDesc())
            Switch(
                checked = true,
                onCheckedChange = { },
                modifier = Modifier.padding(16.dp)
            )
        }
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(viewModel.getIntOptionDesc())
            Switch(
                checked = true,
                onCheckedChange = { },
                modifier = Modifier.padding(16.dp)
            )
        }
        Divider()
        Button(
            onClick = doneCallback,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("DONE")
        }
    }

}


@Preview
@Composable
fun PreviewUserSettingsScreen() {
    SettingsScreen(doneCallback = {})
}