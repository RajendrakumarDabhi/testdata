package com.example.study.data

import androidx.room.ColumnInfo

data class InventoryItem(
    @ColumnInfo(name = "itemName")
    val itemName: String,
    @ColumnInfo(name = "quantityInStock")
    val quantityInStock: Int
)
