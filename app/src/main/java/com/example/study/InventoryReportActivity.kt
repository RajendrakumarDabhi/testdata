package com.example.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study.adapter.OrderAdapter
import com.example.study.data.InventoryItem
import com.example.study.databinding.ActivityInventoryReportBinding
import com.example.study.viewmodel.InventoryViewModel
import com.example.study.viewmodel.ViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InventoryReportActivity : AppCompatActivity() {
    private lateinit var viewModel : InventoryViewModel
    private lateinit var adapter: OrderAdapter
    private var itemList : MutableList<InventoryItem> = mutableListOf()
    private lateinit var binding: ActivityInventoryReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityInventoryReportBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this, ViewModelFactory(application)
        ).get(InventoryViewModel::class.java)


        binding.rvView.layoutManager = LinearLayoutManager(this)
        adapter = OrderAdapter(itemList)
         binding.rvView.adapter = adapter

        getItem(item = InventoryItem("pen",5))
    }

    private fun getItem(item: InventoryItem){
        GlobalScope.launch {

         val data = viewModel.getItemList()
            adapter.updateData(data)

         }


    }
}





