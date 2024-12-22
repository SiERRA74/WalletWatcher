package com.example.walletwatcher.screens

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class AddPurchaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val purchaseType = intent.getStringExtra("PURCHASE_TYPE")?.let {
            PurchaseType.valueOf(it)
        } ?: PurchaseType.WISHLIST

        setContent {
            MaterialTheme {
                AddPurchaseScreen(purchaseType)
            }
        }
    }
}

@Composable
fun AddPurchaseScreen(purchaseType: PurchaseType) {
    var name by remember { mutableStateOf("") }
    var priceText by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            when (purchaseType) {
                PurchaseType.WISHLIST -> "Ajouter à la wishlist"
                PurchaseType.PONCTUEL -> "Ajouter une dépense ponctuelle"
                PurchaseType.RECCURENT -> "Ajouter une dépense récurrente"
            },
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nom") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = priceText,
            onValueChange = {
                priceText = it
                isError = false
            },
            label = { Text("Prix") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    try {
                        val price = priceText.toFloat()
                        if (name.isNotBlank()) {
                            val purchase = Purchase(name, price, purchaseType)
                            // Here you would typically save the purchase
                            // You can use intent.putExtra to send back the result
                            (context as? Activity)?.finish()
                        }
                    } catch (e: NumberFormatException) {
                        isError = true
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Ajouter")
            }

            Button(
                onClick = { (context as? Activity)?.finish() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Annuler")
            }
        }
    }
}
