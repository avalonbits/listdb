package com.avalonbits.listdb.storage

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
data class Note(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "note") val name: String,
    @ColumnInfo(name = "user") val user: String,
)

@Dao
interface NoteDao{
    @Query("SELECT * FROM note ORDER BY uid DESC")
    fun getAll(): List<Note>

    @Insert
    fun addNote(note: Note)

    @Delete
    fun removeNote(uid: String)
}