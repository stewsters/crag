package com.stewsters.crag.engine

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




