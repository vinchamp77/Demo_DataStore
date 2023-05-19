package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import vtsen.hashnode.dev.datastoredemoapp.ui.prefsDataStore

@Composable
fun PrefsDataStoreScreen(doneCallback: ()->Unit) {

    val viewModel: PrefsDataStoreScreenViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current.prefsDataStore)
    )

    val booleanOptionValue by viewModel.booleanOptionState.collectAsStateWithLifecycle()
    val intOptionValue by viewModel.intOptionState.collectAsStateWithLifecycle()

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
            Text(viewModel.getBooleanOptionName())
            Switch(
                checked = booleanOptionValue,
                onCheckedChange = { value ->
                    viewModel.saveBooleanOptionValue(value)
                },
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
            Text(viewModel.getIntOptionName())
            TextField(
                modifier= Modifier.width(70.dp),
                value = intOptionValue.toString(),
                onValueChange = { value ->
                    if (value.isDigitsOnly())
                        viewModel.saveIntOptionValue(value.toInt())
                }
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
fun PreviewPrefsDataStoreScreen() {
    PrefsDataStoreScreen(doneCallback = {})
}