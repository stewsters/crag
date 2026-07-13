package com.stewsters.crag

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventTyep
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stewsters.crag.engine.GameAction
import com.stewsters.crag.engine.GameEngine
import com.stewsters.crag.ui.GameUI

@Composable
@Preview
fun App() {

    val engine = remember { GameEngine() }
    var gameState by remember { mutableStateOf(engine.getState()) }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(
        modifier = Modifier
            .background(Color.Black)
            .padding(16.dp)
            .focusRequester(focusRequester)
            .focusable()
            .onKeyEvent { keyEvent ->
                if (keyEvent.type == KeyEventType.KeyDown) {
                    val action = when (keyEvent.key) {
                        Key.DirectionUp -> GameAction.MoveUp
                        Key.DirectionDown -> GameAction.MoveDown
                        Key.DirectionLeft -> GameAction.MoveLeft
                        Key.DirectionRight -> GameAction.MoveRight
                        else -> null
                    }

                    if (action != null) {
                        engine.processAction(action)
                        gameState = engine.getState()
                        true
                    } else {
                        false
                    }
                } else {
                    false
                }
            }
    ) {
        MaterialTheme {
            Column {
                Text("Dungeon Crawler - Use arrow keys to move", color = Color.White, fontSize = 14.sp)
                GameUI(gameState)
            }
        }
    }

}