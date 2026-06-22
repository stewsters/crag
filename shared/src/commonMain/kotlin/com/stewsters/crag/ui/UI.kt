package com.stewsters.crag.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stewsters.crag.engine.GameState
import com.stewsters.crag.engine.Position

@Composable
fun DungeonGrid(state: GameState) {
    Column {
        for (y in 0 until state.dungeonHeight) {
            Row {
                for (x in 0 until state.dungeonWidth) {
                    DungeonCell(
                        isWall = state.isWall(Position(x, y)),
                        isPlayer = state.playerPos.x == x && state.playerPos.y == y
                    )
                }
            }
        }
    }
}

@Composable
fun DungeonCell(isWall: Boolean, isPlayer: Boolean) {
    val cellSize = 20.dp
    val backgroundColor = when {
        isPlayer -> Color.Yellow
        isWall -> Color.DarkGray
        else -> Color.Black
    }

    Box(
        modifier = Modifier
            .size(cellSize)
            .background(backgroundColor)
            .border(1.dp, Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        if (isPlayer) {
            Text("@", color = Color.Black, fontSize = 12.sp)
        }
    }
}

@Composable
fun GameUI(state: GameState) {
    Column {
        Text("Turn: ${state.turnCount}", fontSize = 16.sp, color = Color.White)
        DungeonGrid(state)
    }
}
