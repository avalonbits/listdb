package com.avalonbits.listdb.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class Datastore : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}