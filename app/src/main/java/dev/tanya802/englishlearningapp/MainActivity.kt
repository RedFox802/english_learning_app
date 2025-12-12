package dev.tanya802.englishlearningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.tanya802.englishlearningapp.app.presentation.screen.RootScreen
import dev.tanya802.englishlearningapp.ui.theme.EnglishLearningAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnglishLearningAppTheme {
                RootScreen()
            }
        }
    }

}