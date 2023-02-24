package com.udeni.saveinfile

import android.content.Context
import java.io.File

class FilerSaver(context: Context) {
    private val context = context
    private val fileName = R.string.file_name.toString()
    fun writeToFile(dataToSave: String) = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        .use { it.write(dataToSave.toByteArray()) }

    fun readFromFile(): String = File(context.filesDir, fileName).readText()
}