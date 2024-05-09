package com.example.mvp_ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_ui.R
import com.example.mvp_ui.databinding.ActivityLoginBinding
import com.example.mvp_ui.default_login.view.DefaultLoginActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
        setListeners()


        //set status bar color to white
        window.statusBarColor = resources.getColor(R.color.white)
    }

    private fun bindViews() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun setListeners() {
        binding.button.setOnClickListener() {
            startActivity(Intent(this, DefaultLoginActivity::class.java))

        }
    }


}