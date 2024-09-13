package com.example.feasta

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.feasta.databinding.ActivityChooseYourLocationBinding

class ChooseYourLocationActivity : AppCompatActivity() {
    private  val binding:ActivityChooseYourLocationBinding by lazy {
        ActivityChooseYourLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val locationList: Array<String> = arrayOf("Mumbai", "Pune", "Nanded", "Ratnagiri", "Chatrapati Sambhaji Nagar","Dharashiv","Kolhapur","Thane","Beed","Nashik","Nagpur","Hingoli","Baramati","Mumbai", "Pune", "Nanded", "Ratnagiri", "Chatrapati Sambhaji Nagar","Dharashiv","Kolhapur","Thane","Beed","Nashik","Nagpur","Hingoli","Baramati")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView = binding.listoflocation
        autoCompleteTextView.setAdapter(adapter)

    }
}