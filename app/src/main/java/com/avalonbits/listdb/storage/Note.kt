package com.avalonbits.listdb.storage

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity
data class Note(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "note") val name: String,
    @ColumnInfo(name = "user") val user: String,
)

@Dao
interface NoteDao{
    @Query("SELECT * FROM note ORDER BY uid DESC")
    fun getAll(): Flow<List<Note>>

    @Query("SELECT COUNT(*) FROM note")
    fun count(): Flow<Int>

    @Insert
    suspend fun addNote(note: Note)

    @Delete
    suspend fun removeNote(note: Note)
}