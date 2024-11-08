package org.mathieu.sandboxdiiage12027

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.mathieu.sandboxdiiage12027.ui.theme.SandboxDiiage12027Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SandboxDiiage12027Theme {

            }
        }
    }
}
