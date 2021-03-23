package com.github.novotnyr.yello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.github.novotnyr.yello.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding
            .inflate(layoutInflater)
            .apply { setContentView(root) }

        binding.noteRecyclerView.layoutManager = GridLayoutManager(this, 3)
    }

    fun onFloatingActionButtonClick(view: View) {}
}