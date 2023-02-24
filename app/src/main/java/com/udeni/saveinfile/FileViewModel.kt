package com.udeni.saveinfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FileViewModel:ViewModel() {
    private val _savedText=MutableLiveData<String>(null)
    val savedText:LiveData<String>get() = _savedText

    fun setInput(savedText:String){
        _savedText.value=savedText
    }
}