package com.avalonbits.listdb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.avalonbits.listdb.storage.Datastore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Datastore.get(applicationContext)

        setContent {
            ListDB(db)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListDB(db: Datastore) {
    var count by remember { mutableIntStateOf(10000) }
    LaunchedEffect(count) {
        //db.noteDao().count().collect() { v -> count = v }
    }

    MainActivityTheme {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(Icons.Filled.Add, "create note")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
        ) {
            if (count == 0) {
                NoNotesYet()
            } else {
                ShowNotes()
            }
            
        }
    }
}

@Composable
fun NoNotesYet() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.no_notes_yet))
    }
}

@Composable
fun ShowNotes() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            Column(

            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Title",
                    textAlign = TextAlign.Left,
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "This is a very long string, one that I don't think I should be "+
                           " weg able to see in a single bout brglkejgrlk",
                    textAlign = TextAlign.Left,
                )
            }
        }
    }
}

