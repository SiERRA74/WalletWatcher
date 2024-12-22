package com.example.walletwatcher.screens

// Purchase.kt (Data class to be shared)
data class Purchase(
    val name: String,
    val price: Float,
    val type: PurchaseType
)

enum class PurchaseType {
    WISHLIST,
    PONCTUEL,
    RECCURENT
}