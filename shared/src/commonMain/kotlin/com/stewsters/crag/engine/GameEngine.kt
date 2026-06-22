package com.stewsters.crag.engine

class GameEngine {
    private var state = GameState(playerPos = Position(16, 16))

    fun getState(): GameState = state

    fun processAction(action: GameAction) {
        state = updateGameState(state, action)
    }

    fun reset() {
        state = GameState(playerPos = Position(16, 16))
    }
}
