package com.stewsters.crag.engine

sealed class GameAction {
    object MoveUp : GameAction()
    object MoveDown : GameAction()
    object MoveLeft : GameAction()
    object MoveRight : GameAction()
}