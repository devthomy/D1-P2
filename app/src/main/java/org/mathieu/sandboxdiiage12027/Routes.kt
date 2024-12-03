package org.mathieu.sandboxdiiage12027

object Routes {
    const val LoginScreen = "login_screen"
    const val PlayerDashboard = "player_dashboard/{name}"

    fun PlayerDashboard(name: String): String {
        return "player_dashboard/$name"
    }
}
