package com.stewsters.crag.ecs.component

import com.stewsters.crag.ecs.enums.Slot

data class Equipment(val slot: Slot, var isEquipped: Boolean = false)
