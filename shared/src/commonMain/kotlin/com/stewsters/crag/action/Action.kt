package com.stewsters.crag.action

import com.stewsters.crag.ecs.entity.Entity
import com.stewsters.crag.map.MapChunk

// An entity does something. verbs
abstract class Action(
    var pawn: Entity,
    var chunkMap: MapChunk = pawn.chunk,
    var costInTurns: Int = 100
) {

    open fun onPerform(): ActionResult {
        return ActionResult.FAILURE
    }

//    override fun toString(): String {
//        return javaClass.name.split('.').last()
//    }

}