package com.stewsters.crag.action

import com.stewsters.crag.ecs.entity.Entity

class AttackAction(pawn: Entity, private var target: Entity) : Action(pawn) {

    override fun onPerform(): ActionResult {

        val targetLife = target.life

        if (targetLife == null) {
            return ActionResult.FAILURE
        }

        targetLife.damage(1)

        if (targetLife.cur <= 0) {
            target.deathFunction(target)
        }

        return ActionResult.SUCCESS
    }

}
