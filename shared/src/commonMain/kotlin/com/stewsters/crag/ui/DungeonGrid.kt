package com.stewsters.crag.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
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