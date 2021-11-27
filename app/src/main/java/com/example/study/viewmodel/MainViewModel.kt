package com.example.study.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.study.data.InventoryItem
import com.example.study.data.Item
import com.example.study.data.ItemDatabase
import com.example.study.repo.MainRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    var itemDatabase : ItemDatabase
    var mainRepository  : MainRepository

    init {
        itemDatabase = ItemDatabase.getDatabase(getApplication())
        mainRepository = MainRepository(itemDatabase.itemDao())
    }

    suspend fun getItembyName(name:String) : MutableList<Item>{
        return mainRepository.getItembyName(name)
    }

    suspend fun insertItem(item: Item) {
        mainRepository.insertItem(item)
    }

    suspend fun updateItem(name:String,qty:Int){
        mainRepository.updateItem(name,qty)
    }
}