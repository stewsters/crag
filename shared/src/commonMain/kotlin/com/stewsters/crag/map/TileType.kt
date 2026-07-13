package com.stewsters.crag.map

import androidx.compose.ui.graphics.Color


enum class TileType(
    val word: String,
    val blocks: Boolean,
    val char: Int,
    val foreground: Color,
    val background: Color = Color.Black,
    val transparent: Boolean = false
) {
    AIR("air", false, ' '.code, Color(0, 0, 0, 0), Color(0, 0, 0, 0), true),
    GRASS("grass", false, '.'.code, Color.Black, Color(20, 200, 20)),
    TREE("tree", true, '£'.code, Color.Black, Color(20, 150, 20)),

    WALL("wall", true, 'X'.code, Color.Black, Color.White),
    STONE_FLOOR("stone floor", false, '.'.code, Color.Black, Color.Gray),

    OPEN_DOOR("open door", false, '-'.code, Color.Black, Color.LightGray),
    CLOSED_DOOR("closed door", true, '+'.code, Color.Black, Color.LightGray),

    WATER_SWAMP("swamp", false, ';'.code, Color(255, 222, 173), Color(160, 82, 45)),
    WATER_LAKE("lake", false, '~'.code, Color.Cyan, Color.Blue),

    UP_STAIR("up stair", false, '<'.code, Color.Black, Color.White),
    DOWN_STAIR("down stair", false, '>'.code, Color.Black, Color.White);
}