package com.stewsters.crag.action

import com.stewsters.crag.math.Vec3
import com.stewsters.crag.ecs.entity.Entity
import com.stewsters.crag.map.TileType


class DescendAction(pawn: Entity) : Action(pawn) {

    override fun onPerform(): ActionResult {
        val tile = chunkMap.at(pawn.pos)

        if (tile.type == TileType.DOWN_STAIR) {
            pawn.chunk.updatePawnPos(pawn, pawn.pos + Vec3(0, 0, -1))
            return ActionResult.SUCCESS
        } else {
            return ActionResult.FAILURE
        }
    }

}
