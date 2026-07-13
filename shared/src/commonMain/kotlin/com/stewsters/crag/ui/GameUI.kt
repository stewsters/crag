package com.stewsters.crag.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.stewsters.crag.engine.GameState

@Composable
fun GameUI(state: GameState) {
    Column {
        Text("Turn: ${state.turnCount}", fontSize = 16.sp, color = Color.White)
        DungeonGrid(state)
    }
}
