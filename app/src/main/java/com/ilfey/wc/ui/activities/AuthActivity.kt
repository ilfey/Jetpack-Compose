package com.ilfey.wc.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.ilfey.wc.R
import com.ilfey.wc.ui.components.navigation.AuthScreenNavigationConfiguration
import com.ilfey.wc.ui.theme.WorldCinemaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_WorldCinema)

//        TODO check auth
        /*
        val intent = Intent(ctx, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        ctx.startActivity(intent)
        */

        setContent {
            val navController = rememberNavController()
            WorldCinemaTheme {
                AuthScreenNavigationConfiguration(navHostController = navController)
            }
        }
    }
}