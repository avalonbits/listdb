package com.avalonbits.listdb.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class Datastore : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object Instance {
        private var INSTANCE: Datastore? = null
        fun get(context: Context): Datastore {
            synchronized(Datastore::class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        Datastore::class.java,
                        "notes"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}