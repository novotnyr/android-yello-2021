package com.github.novotnyr.yello

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1)
abstract class YelloDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        val DATABASE_NAME = "yello"

        @Volatile
        private var db: YelloDatabase? = null

        operator fun invoke(context: Context): YelloDatabase =
            db ?: synchronized(this) {
                db ?: context.buildDatabase()
                    .also {
                        db = it
                    }
            }

        private fun Context.buildDatabase(): YelloDatabase {
            return Room.databaseBuilder(
                applicationContext,
                YelloDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}