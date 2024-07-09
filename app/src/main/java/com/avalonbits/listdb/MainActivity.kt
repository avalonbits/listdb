package com.avalonbits.listdb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.room.Room
import com.avalonbits.listdb.storage.Datastore
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            Datastore::class.java,
            "notes"
        ).build()

        setContent {
            ListDB(db)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListDB(db: Datastore) {
    var count by remember { mutableStateOf(10000) }
    val dbCoroutineScope = rememberCoroutineScope()
    dbCoroutineScope.launch { count = db.noteDao().count()}

    MainActivityTheme {
        Scaffold {
            Text(text = "Hello, world! We have $count notes")
        }
    }
}

