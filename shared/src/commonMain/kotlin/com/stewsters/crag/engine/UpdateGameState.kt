package com.stewsters.crag.engine

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