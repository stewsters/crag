package com.stewsters.crag.action

import com.stewsters.crag.ecs.entity.Entity
import com.stewsters.crag.map.TileType
import com.stewsters.crag.math.Vec3


class OpenDoorAction(pawn: Entity, private val pos: Vec3) : Action(pawn) {

    override fun onPerform(): ActionResult {

        if (!pawn.doorOpener) {
            return ActionResult.FAILURE
        }
        if (chunkMap.at(pos).type !== TileType.CLOSED_DOOR) {
            return ActionResult.FAILURE
        }

        chunkMap.at(pos).type = TileType.OPEN_DOOR

        return ActionResult.SUCCESS

    }
}