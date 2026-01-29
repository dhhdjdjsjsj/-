package com.example.notepad

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var noteEditor: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteEditor = findViewById(R.id.note_editor)
        val saveButton: Button = findViewById(R.id.save_button)
        val clearButton: Button = findViewById(R.id.clear_button)

        noteEditor.setText(loadNote())

        saveButton.setOnClickListener {
            saveNote(noteEditor.text.toString())
            Toast.makeText(this, R.string.note_saved, Toast.LENGTH_SHORT).show()
        }

        clearButton.setOnClickListener {
            noteEditor.setText("")
        }
    }

    private fun saveNote(note: String) {
        getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_NOTE, note)
            .apply()
    }

    private fun loadNote(): String {
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(KEY_NOTE, "") ?: ""
    }

    companion object {
        private const val PREFS_NAME = "notepad_prefs"
        private const val KEY_NOTE = "saved_note"
    }
}
