package com.example.clean_architecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.clean_architecture.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        Log.e("ddd", "Activity created")

        vm.resultLive.observe(this) {
            b.dataTextView.text = it
        }

        b.sendButton.setOnClickListener {
            val text = b.dataEditText.text.toString()
            vm.save(text)
        }

        b.receiveButton.setOnClickListener {
            vm.load()
        }
    }
}