package com.udeni.saveinfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.udeni.saveinfile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: FileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.fileVM = viewModel
        binding.lifecycleOwner = this

        binding.btnSave.setOnClickListener {
            viewModel.setInput(binding.txtData.text.toString())
            FilerSaver(this).writeToFile(viewModel.savedText.value.toString())
        }
        binding.btnView.setOnClickListener {
            viewModel.setInput(FilerSaver(this).readFromFile())
        }
    }
}