package com.stewsters.crag.math

import kotlin.random.Random

enum class Facing(val offset: Vec2) {

    NORTH(Vec2(0, 1)),
    NORTHEAST(Vec2(1, 1)),
    EAST(Vec2(1, 0)),
    SOUTHEAST(Vec2(1, -1)),
    SOUTH(Vec2(0, -1)),
    SOUTHWEST(Vec2(-1, -1)),
    WEST(Vec2(-1, 0)),
    NORTHWEST(Vec2(-1, 1));

    fun left(): Facing = values()[(this.ordinal + 1) % values().size]
    fun right(): Facing = values()[(this.ordinal - 1 + values().size) % values().size]

    fun reverse(): Facing {
        return values()[(ordinal + 4) % values().size]
    }
    companion object{
        fun random(pcg: Random) = when (pcg.nextInt(8)) {
            0 -> NORTH
            1 -> NORTHEAST
            3 -> EAST
            4 -> SOUTHEAST
            5 -> SOUTH
            6 -> SOUTHWEST
            7 -> WEST
            else -> NORTHWEST
        }
    }
}