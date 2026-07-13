package com.stewsters.crag.action

import com.stewsters.crag.ecs.entity.Entity
import com.stewsters.crag.map.TileType
import kaiju.math.Vec3

class AscendAction(pawn: Entity) : Action(pawn) {

    override fun onPerform(): ActionResult {
        val tile = chunkMap.at(pawn.pos)

        if (tile.type == TileType.UP_STAIR) {
            pawn.chunk.updatePawnPos(pawn, pawn.pos + Vec3(0, 0, 1))
            return ActionResult.SUCCESS
        } else {
            return ActionResult.FAILURE
        }
    }

}
