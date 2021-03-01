package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun GestureAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.GestureAnimation.capitalize(Locale.getDefault())
    ) {
        GestureAnimationExample()
    }
}

private enum class ComponentState { Pressed, Released }

@Composable
fun GestureAnimationExample() {
    var useRed by remember { mutableStateOf(false) }
    var toState by remember { mutableStateOf(ComponentState.Released) }
    val modifier = Modifier.pointerInput(Unit) {
        detectTapGestures(onPress = {
            toState = ComponentState.Pressed
            val success = tryAwaitRelease()
            toState = if (success) {
                ComponentState.Released
            } else {
                ComponentState.Released
            }
        })
    }

    val transition: Transition<ComponentState> = updateTransition(targetState = toState)
    val scale: Float by transition.animateFloat(
        transitionSpec = { spring(stiffness = 50f) }
    ) { state ->
        if (state == ComponentState.Pressed) 3f else 1f
    }

    val color: Color by transition.animateColor(
        transitionSpec = {
            if (this.initialState == ComponentState.Pressed
                && this.targetState == ComponentState.Released
            ) {
                spring(stiffness = 50f)
            } else {
                tween(durationMillis = 500)
            }
        }
    ) { state ->
        when (state) {
            ComponentState.Pressed -> MaterialTheme.colors.primary
            ComponentState.Released -> if (useRed) Color.Red else MaterialTheme.colors.secondary
        }
    }
    Column {
        Button(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { useRed = !useRed }
        ) {
            Text("Change Color")
        }
        Box(
            modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .requiredSize((100 * scale).dp)
                .background(color)
        )
    }
}