package org.mathieu.sandboxdiiage12027.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mathieu.sandboxdiiage12027.R
import org.mathieu.sandboxdiiage12027.ui.composables.login.LoginCard

@Preview
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = colorResource(R.color.alto)),
        contentAlignment = Alignment.Center
    ) {
        Text("CYBER QUEST")
        LoginCard { username, password ->
            // Handle login logic here
            println("Username: $username, Password: $password")
        }
    }
}