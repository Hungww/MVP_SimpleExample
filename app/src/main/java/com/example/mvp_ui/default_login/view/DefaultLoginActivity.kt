package com.example.mvp_ui.default_login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.mvp_ui.R
import com.example.mvp_ui.databinding.ActivityDefaultLoginBinding
import com.example.mvp_ui.default_login.presenter.DefaultLoginPresenter
import com.example.mvp_ui.home.view.HomeActivity

class DefaultLoginActivity : AppCompatActivity(), IDefaultLoginVIew{
    private lateinit var binding: ActivityDefaultLoginBinding
    private lateinit var presenter: DefaultLoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
        setListeners()
        presenter = DefaultLoginPresenter(this)
    }
    private fun bindViews() {
        binding = ActivityDefaultLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun setListeners() {
        binding.imageButton.setOnClickListener() {
            finish()
        }
        binding.emailTextField.editText?.addTextChangedListener { text ->
            if (text.toString().isNotEmpty() && binding.passwordTextField.editText?.text.toString().isNotEmpty()) {
                binding.loginButton.isEnabled = true
                binding.loginButton.setBackgroundColor(resources.getColor(R.color.main_green))
            } else {
                binding.loginButton.isEnabled = false
                binding.loginButton.setBackgroundColor(resources.getColor(R.color.gray))

            }
        }
        binding.passwordTextField.editText?.addTextChangedListener { text ->
            if (text.toString().isNotEmpty() && binding.emailTextField.editText?.text.toString().isNotEmpty()) {
                binding.loginButton.isEnabled = true
                binding.loginButton.setBackgroundColor(resources.getColor(R.color.main_green))
            } else {
                binding.loginButton.isEnabled = false
                binding.loginButton.setBackgroundColor(resources.getColor(R.color.gray))

            }
        }
        binding.loginButton.setOnClickListener() {
            val email = binding.emailTextField.editText?.text.toString()
            val password = binding.passwordTextField.editText?.text.toString()
            presenter.onLogin(email, password)
        }
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
        var i = Intent(this, HomeActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }

    override fun onLoginFailed() {
        Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

}