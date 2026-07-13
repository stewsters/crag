package com.stewsters.crag.action

import com.stewsters.crag.ecs.entity.Entity

class RestAction(pawn: Entity) : Action(pawn) {

    override fun onPerform(): ActionResult {
        if (pawn.life != null) {
            pawn.life?.heal(1)
        }
        return ActionResult.SUCCESS
    }
}
