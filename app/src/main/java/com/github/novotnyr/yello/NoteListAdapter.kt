package com.github.novotnyr.yello

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.novotnyr.yello.databinding.NoteBinding

object NoteDiff : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.description == newItem.description
                && oldItem.timestamp == newItem.timestamp
    }
}

class NoteViewHolder(val binding: NoteBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(note: Note) {
        val period = DateUtils.getRelativeTimeSpanString(note.timestamp)
        binding.noteDescriptionTextView.text = "${note.description}\n($period)"
    }
}

class NoteListAdapter : ListAdapter<Note, NoteViewHolder>(NoteDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NoteBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
