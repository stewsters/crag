package com.stewsters.crag.engine

data class Position(val x: Int, val y: Int)

data class GameState(
    val playerPos: Position,
    val dungeonWidth: Int = 32,
    val dungeonHeight: Int = 32,
    val turnCount: Int = 0
) {
    fun isWall(pos: Position): Boolean {
        return pos.x <= 0 || pos.x >= dungeonWidth - 1 ||
               pos.y <= 0 || pos.y >= dungeonHeight - 1
    }

    fun isWalkable(pos: Position): Boolean {
        return pos.x >= 0 && pos.x < dungeonWidth &&
               pos.y >= 0 && pos.y < dungeonHeight &&
               !isWall(pos)
    }
}

sealed class GameAction {
    object MoveUp : GameAction()
    object MoveDown : GameAction()
    object MoveLeft : GameAction()
    object MoveRight : GameAction()
}

fun updateGameState(state: GameState, action: GameAction): GameState {
    val newPos = when (action) {
        GameAction.MoveUp -> state.playerPos.copy(y = state.playerPos.y - 1)
        GameAction.MoveDown -> state.playerPos.copy(y = state.playerPos.y + 1)
        GameAction.MoveLeft -> state.playerPos.copy(x = state.playerPos.x - 1)
        GameAction.MoveRight -> state.playerPos.copy(x = state.playerPos.x + 1)
    }

    return if (state.isWalkable(newPos)) {
        state.copy(playerPos = newPos, turnCount = state.turnCount + 1)
    } else {
        state
    }
}
