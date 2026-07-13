package com.stewsters.crag.action

import com.stewsters.crag.ecs.entity.Entity
import com.stewsters.crag.ecs.system.Msg

class HarvestAction(pawn: Entity) : Action(pawn) {

    override fun onPerform(): ActionResult {

        if (pawn.mount != null) {
            //on horse, dismount?
            return ActionResult(alternative = DismountAction(pawn))
        }

        val others = pawn.chunk.pawnInSquare(pawn.pos).filter {
            it != pawn && it.inventory != null
        }

        if (others.isEmpty()) {
            // nothing there
            return ActionResult.FAILURE
        }

        val inventoryToEmpty = others.first().inventory
        if (inventoryToEmpty == null) {
            return ActionResult.FAILURE
        }

        val itemsPickedUp: List<Entity> = inventoryToEmpty.items


        if (itemsPickedUp.isEmpty()) {
            return ActionResult.FAILURE
        }

        others.first().inventory?.items?.clear()
        pawn.inventory?.items?.addAll(itemsPickedUp)
        Msg.log("Harvested ${itemsPickedUp.joinToString(", ") { it.name }}")
        return ActionResult.SUCCESS
    }
}