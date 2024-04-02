package com.amitwc.selfhelpbooks

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.amitwc.selfhelpbooks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //window.statusBarColor= Color.TRANSPARENT

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener{

            launcher.launch("application/pdf")

        }

    }

    private val launcher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ){
        uri->
        uri?.let {
            binding.pdfView.fromUri(it).load()


        }
    }


}