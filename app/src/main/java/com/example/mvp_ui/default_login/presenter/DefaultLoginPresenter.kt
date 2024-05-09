package com.example.mvp_ui.default_login.presenter
import com.example.mvp_ui.default_login.view.IDefaultLoginVIew
class DefaultLoginPresenter(var view: IDefaultLoginVIew): IDefaultLoginPresenter{


    override fun onLogin(email: String, password: String) {
        try {
            //Just some dummy data
            if (email == "admin@gmail.com" && password == "123") {
                view.onLoginSuccess()
            } else {
                view.onLoginFailed()
            }
        }
        catch (e: Exception) {
            view.onLoginError()
        }

    }
}