package com.example.feasta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.feasta.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding : ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.PlaceMyOrderButton.setOnClickListener {
            val BottomSheetDialog = CongratsBottomSheet()
            BottomSheetDialog.show(supportFragmentManager,"Test")
        }
    }
}