package com.example.composequadrant

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.top_left_content),
                backgroundColor = (R.color.top_left_color),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.top_right_content),
                backgroundColor = (R.color.top_right_color),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.bottom_left_content),
                backgroundColor = (R.color.bottom_left_color),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.column_composable),
                description = stringResource(R.string.bottom_right_content),
                backgroundColor = (R.color.bottom_right_color),
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = backgroundColor))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}