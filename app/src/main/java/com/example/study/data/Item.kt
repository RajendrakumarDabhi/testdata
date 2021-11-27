package com.example.study.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Item(var itemName : String, var cost : Double, var quantityInStock : Int,
           var totalCost : Double, var transactionDate: Long,var isPurchase: Boolean)
{

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}



