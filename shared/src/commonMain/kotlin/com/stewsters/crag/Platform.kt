package com.stewsters.crag

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform