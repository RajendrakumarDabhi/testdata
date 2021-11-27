package com.example.study.data

import androidx.room.*

@Dao
interface ItemDao {

    @Query("SELECT itemName, quantityInStock from item")
    fun getItem():MutableList<InventoryItem>

    @Query("SELECT * from item where itemName=:name")
    fun getItembyName(name:String):MutableList<Item>

    @Insert
    suspend fun insert(item: Item)

    @Query("UPDATE item SET quantityInStock=:qty where itemName=:name")
    fun updateQty(name: String,qty:Int)
}