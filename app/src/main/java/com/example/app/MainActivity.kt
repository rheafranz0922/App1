package com.example.app

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val dropdownlist1 = arrayOf("blue", "red")
    val dropdownlist2 = arrayOf("yellow", "blue")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dropdownlist1)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dropdownlist2)

        binding.paletteA.adapter = adapter1
        binding.paletteB.adapter = adapter2

        binding.button.setOnClickListener {
            val selectedItem1 = binding.paletteA.selectedItem.toString()
            val selectedItem2 = binding.paletteB.selectedItem.toString()
            val result = when {
                selectedItem1 == "blue" && selectedItem2 == "red" -> "The result is violet"
                selectedItem1 == "blue" && selectedItem2 == "yellow" -> "The result is green"
                selectedItem1 == "blue" && selectedItem2 == "blue" -> "The result is blue"
                selectedItem1 == "red" && selectedItem2 == "yellow" -> "The result is red"
                else -> "No result"
            }
            binding.textView5.text = result
        }
    }
}