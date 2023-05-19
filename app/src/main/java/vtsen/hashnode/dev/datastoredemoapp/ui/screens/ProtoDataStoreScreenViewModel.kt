package vtsen.hashnode.dev.datastoredemoapp.ui.screens

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import vtsen.hashnode.dev.datastoredemoapp.ProtoPreferences

class ProtoDataStoreScreenViewModel(
    private val dataStore: DataStore<ProtoPreferences>
) : ViewModel() {

    private val articles = listOf("Article 1", "Article 2", "Article 3")

    init {
        for (article in articles) {
            saveBookmarkedArticle(article, bookmarked = false)
        }
    }

    val bookmarkedArticlesState = dataStore.data.map { protoPreferences ->
            protoPreferences.bookmarkedArticleIdsMap
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = null)

    fun saveBookmarkedArticle(articleId: String, bookmarked: Boolean) {
        viewModelScope.launch {
            dataStore.updateData { protoPreferences ->
                protoPreferences.toBuilder()
                    .putBookmarkedArticleIds(articleId, bookmarked)
                    .build()
            }
        }
    }
}