package org.me.navigation

sealed class Navigation {
    object Request : Navigation()
    data class Response(val response: Int) : Navigation()
}