package com.example.study.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(val context: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(context) as T
        }
        else if(modelClass.isAssignableFrom(InventoryViewModel::class.java)){
            return InventoryViewModel(context) as T
        }
        throw IllegalArgumentException("Class not found")
    }
}