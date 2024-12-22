package com.example.walletwatcher.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecurrentScreen() {
    // État pour gérer les éléments de la liste
    var items by remember { mutableStateOf(listOf<String>()) }

    // État pour gérer le nouveau nom d'élément
    var newItem by remember { mutableStateOf("") }

    // État pour afficher ou non la boîte de dialogue
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Dépenses récurrentes", fontSize = 24.sp)

        // Liste scrollable
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(items) { item ->
                Text(
                    text = item,
                    modifier = Modifier.padding(8.dp),
                    fontSize = 16.sp
                )
            }
        }

        // Bouton Ajouter
        Button(onClick = { showDialog = true }) {
            Text("Ajouter")
        }

        // Popup pour ajouter un élément
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Ajouter un élément") },
                text = {
                    Column {
                        Text("Entrez un nom :")
                        Spacer(modifier = Modifier.height(8.dp))
                        BasicTextField(
                            value = newItem,
                            onValueChange = { newItem = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.surface)
                                .padding(8.dp)
                        )
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        if (newItem.isNotBlank()) {
                            items = items + newItem
                            newItem = ""
                        }
                        showDialog = false
                    }) {
                        Text("Ajouter")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Annuler")
                    }
                }
            )
        }
    }
}
