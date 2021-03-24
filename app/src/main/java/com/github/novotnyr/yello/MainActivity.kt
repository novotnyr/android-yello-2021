package com.github.novotnyr.yello

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.github.novotnyr.yello.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding
            .inflate(layoutInflater)
            .apply { setContentView(root) }

        binding.noteRecyclerView.layoutManager = GridLayoutManager(this, 3)
        val noteListAdapter = NoteListAdapter()
        binding.noteRecyclerView.adapter = noteListAdapter

        noteViewModel.notes.observe(this, noteListAdapter::submitList)
    }

    fun onFloatingActionButtonClick(view: View) {
        val descriptionEditText = EditText(this)

        AlertDialog.Builder(this)
            .setView(descriptionEditText)
            .setPositiveButton("Save") { _, _ ->
                val description = descriptionEditText.text.toString()
                noteViewModel.add(Note(description = description))
            }
            .show()
    }
}