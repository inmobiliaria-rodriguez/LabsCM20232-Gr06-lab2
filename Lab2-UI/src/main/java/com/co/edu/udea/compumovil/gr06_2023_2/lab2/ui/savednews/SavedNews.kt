package com.co.edu.udea.compumovil.gr06_2023_2.lab2.ui.savednews

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.co.edu.udea.compumovil.gr06_2023_2.lab2.data.room.PostViewModel

@Composable
fun SavedNewsComponent(viewModel: PostViewModel) {
    val tableData = viewModel.state.postList

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            // Encabezado de la tabla
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(4.dp)
            ) {
                Text(
                    "Title",
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    "Subtitle",
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    "Url",
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    "Id",
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        items(tableData) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(4.dp)
                    .border(BorderStroke(1.dp, Color.Gray))
            ) {
                Row {
                    Text(item.title, modifier = Modifier
                        .weight(1f)
                        .padding(4.dp))
                    Text(item.subtitle, modifier = Modifier
                        .weight(1f)
                        .padding(4.dp))
                    Text(item.url, modifier = Modifier
                        .weight(1f)
                        .padding(4.dp))
                    Text(item.id, modifier = Modifier
                        .weight(1f)
                        .padding(4.dp))
                }
            }
        }
    }
}

