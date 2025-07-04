package de.benkralex.socius.pages

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.benkralex.socius.widgets.ContactsList
import de.benkralex.socius.backend.Contact

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ContactListPage(
    modifier: Modifier = Modifier,
    contacts: List<Contact>,
    menuBar: @Composable () -> Unit,
    onContactSelected: (Int) -> Unit = {},
    onSettingsSelected: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Log.d("ContactsListPage", "Add new Contact clicked")
            }) {
                Icon(Icons.Filled.Add, "Add")
            }
        },
        bottomBar = {
            menuBar()
        }
    ) { paddingValues ->
        ContactsList(
            contacts = contacts,
            paddingValues = paddingValues,
            onContactSelected = onContactSelected,
            onSettingsSelected = onSettingsSelected
        )
    }
}