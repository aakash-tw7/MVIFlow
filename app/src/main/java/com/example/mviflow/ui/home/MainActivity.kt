package com.example.mviflow.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mviflow.R
import com.example.mviflow.ui.signin.SignInAction
import com.example.mviflow.ui.signin.SignInFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SignInFragment())
                .commitNow()
        }
    }
}