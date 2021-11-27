package com.example.study.repo

import com.example.study.data.InventoryItem
import com.example.study.data.Item
import com.example.study.data.ItemDao

class MainRepository(var ItemDao : ItemDao) {

    suspend fun insertItem(item: Item){
        ItemDao?.insert(item)
    }

    suspend fun getItem(): MutableList<InventoryItem> {
        return ItemDao?.getItem()
    }

    suspend fun getItembyName(name:String): MutableList<Item> {
        return ItemDao?.getItembyName(name)
    }
    suspend fun updateItem(name:String,qty:Int) {
         ItemDao?.updateQty(name,qty)
    }


}