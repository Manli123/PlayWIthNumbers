package com.example.oneclickdrive.Ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.oneclickdrive.R
import com.example.oneclickdrive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

//        setContentView(R.layout.activity_main)

        binding.calculate.setOnClickListener {
            val list1 = binding.editTxt1.text.toString().split(",").map { it.trim().toInt() }
            val list2 = binding.editTxt2.text.toString().split(",").map { it.trim().toInt() }
            val list3 = binding.editTxt3.text.toString().split(",").map { it.trim().toInt() }

            val intersect = list1.intersect(list2).intersect(list3)
            val union = list1.union(list2).union(list3)
            val maxNumber = union.maxOrNull()

            val result = """
                Intersect: ${intersect.joinToString(", ")}
                Union: ${union.joinToString(", ")}
                Highest Number: $maxNumber
            """.trimIndent()

            binding.result.text = result
        }
    }
}