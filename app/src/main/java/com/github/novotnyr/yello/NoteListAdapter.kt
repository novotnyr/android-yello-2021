package com.github.novotnyr.yello

import androidx.recyclerview.widget.DiffUtil

object NoteDiff : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.description == newItem.description
                && oldItem.timestamp == newItem.timestamp
    }
}