package com.yeditepe.finalexam.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.yeditepe.finalexam.model.Task

private val Int.isCompleted: Boolean
private val Int.title: String
private val NavHostController.tasks: Any

@Composable
fun TaskListScreen(viewModel: NavHostController = viewModel()) {
    val taskList = viewModel.tasks

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(taskList as Int) { task ->
            Text(
                text = "${task.title} - ${if (task.isCompleted) "Completed" else "Not Completed"}",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}


@Composable
fun TaskRow(task: Task, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("taskDetail/${Uri.equals(task.title)}")
            }
            .padding(12.dp)
    ) {
        Text(
            text = task.title,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
//

