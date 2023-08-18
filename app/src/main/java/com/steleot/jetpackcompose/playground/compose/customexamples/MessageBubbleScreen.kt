package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Surface
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "customexamples/MessageBubbleScreen.kt"

@Composable
fun MessageBubbleScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.MessageBubble,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            MessageBubble(stringResource(id = R.string.incoming_message), true)
            MessageBubble(stringResource(id = R.string.compose_coming), false)
        }
    }
}

private val incomingShape = RoundedCornerShape(
    topStart = 8.dp,
    topEnd = 8.dp,
    bottomEnd = 8.dp,
    bottomStart = 0.dp
)

private val outgoingShape = RoundedCornerShape(
    topStart = 8.dp,
    topEnd = 8.dp,
    bottomEnd = 0.dp,
    bottomStart = 8.dp
)

@Composable
private fun MessageBubble(
    text: String,
    isIncoming: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            shape = if (isIncoming) incomingShape else outgoingShape,
            color = if (isIncoming) MaterialTheme.colors.secondary else MaterialTheme.colors.primary,
            modifier = modifier
                .padding(8.dp)
                .align(if (isIncoming) Alignment.Start else Alignment.End)
        ) {
            Text(
                text = text,
                fontSize = 14.sp,
                modifier = Modifier.padding(8.dp),
                textAlign = if (isIncoming) TextAlign.Start else TextAlign.End
            )
        }
    }
}
