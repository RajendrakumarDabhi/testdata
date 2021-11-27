package com.example.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.study.data.Item
import com.example.study.databinding.ActivityMainBinding
import com.example.study.viewmodel.MainViewModel
import com.example.study.viewmodel.ViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this, ViewModelFactory(application)
        ).get(MainViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAdd.setOnClickListener {
            GlobalScope.launch {
                var items =  viewModel.getItembyName(binding.edtName.toString().trim())
                insertData(items)
            }
        }
        binding.btnShow.setOnClickListener {

            val intent = Intent(this, InventoryReportActivity::class.java)
            startActivity(intent)
        }
    }

    suspend fun insertData(items: MutableList<Item>) {
        val name = binding.edtName.text.toString()
        val cost = binding.edtCost.text.toString().toDouble()
        val qty = binding.edtQuantity.text.toString().toInt()

        if (items != null && items.size > 0) {
            var mqty = getQuentitytoUpdate(qty)
            viewModel.updateItem(items.get(0).itemName,mqty)
        } else {
            var tcost = qty * cost
            val item = Item(name, cost, qty, tcost,System.currentTimeMillis(),isPurchase())
            viewModel.insertItem(item)
        }
    }

    fun getQuentitytoUpdate(qty: Int): Int {
        var qty = qty
        if (isPurchase()) {
            qty += binding.edtQuantity.text.toString().toInt()
        } else {
            qty -= binding.edtQuantity.text.toString().toInt()
        }
        return qty
    }
    fun isPurchase(): Boolean {
        val id = binding.radioGroup.checkedRadioButtonId
        return id == R.id.rb_purchase
    }
}