package com.example.walletwatcher.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Intent
import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext



@Composable
fun WishlistScreen() {
    var items by remember { mutableStateOf(listOf<Purchase>()) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Wishlist", fontSize = 24.sp)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(item.name)
                        Text("${item.price}€")
                    }
                }
            }
        }

        Button(
            onClick = {
                val intent = Intent(context, AddPurchaseActivity::class.java).apply {
                    putExtra("PURCHASE_TYPE", PurchaseType.WISHLIST.name)
                }
                context.startActivity(intent)
            }
        ) {
            Text("Ajouter")
        }
    }
}