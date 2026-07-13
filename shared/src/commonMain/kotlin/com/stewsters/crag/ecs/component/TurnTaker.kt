package com.stewsters.crag.ecs.component

import com.stewsters.crag.action.Action
import com.stewsters.crag.ecs.entity.Entity
import com.stewsters.crag.map.MapChunk

// This controls Entities that do stuff on turns
data class TurnTaker(
    var gameTurn: Int,
    var ai: (MapChunk, Entity) -> Action?,
    var parent: Entity? = null
) : Comparable<TurnTaker> {

    private var action: Action? = null

    fun nextAction(mapChunk: MapChunk, entity: Entity): Action? {
        // if we have a planned action, do that, otherwise query AI
        return action ?: ai(mapChunk, entity)
    }

    fun setNextAction(action: Action?) {
        this.action = action
    }

    override fun compareTo(other: TurnTaker): Int {
        return gameTurn.compareTo(other.gameTurn)
    }

}