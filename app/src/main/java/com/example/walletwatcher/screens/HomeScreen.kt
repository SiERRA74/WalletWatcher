package com.example.walletwatcher.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Budget \"fun\" restant :", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text("24.12€", fontSize = 36.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { onNavigate("recurrent") }) { Text("Recurrent") }
            Button(onClick = { onNavigate("ponctuel") }) { Text("Ponctuel") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigate("wishlist") }) { Text("Wishlist") }
    }
}
