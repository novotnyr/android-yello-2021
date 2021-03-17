package com.github.novotnyr.yello

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val db = YelloDatabase(application)

    private val noteDao: NoteDao = db.noteDao()

    val notes: LiveData<List<Note>> = noteDao.list()
}