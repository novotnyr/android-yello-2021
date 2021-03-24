package com.github.novotnyr.yello

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.*

object NoteDiff : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.description == newItem.description
                && oldItem.timestamp == newItem.timestamp
    }
}

class NoteViewHolder(root: View) : RecyclerView.ViewHolder(root) {
    val text1: TextView = root.findViewById(android.R.id.text1)

    fun bind(note: Note) {
        text1.text = "${note.description} (${Date(note.timestamp)})"
    }
}