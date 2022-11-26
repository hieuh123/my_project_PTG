package gst.trainingcourse.mvvm_databinding_livedata_hieudn9.View

import android.arch.lifecycle.LifecycleOwner
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import gst.trainingcourse.mvvm_databinding_livedata_hieudn9.Model.LoginUser
import gst.trainingcourse.mvvm_databinding_livedata_hieudn9.R
import gst.trainingcourse.mvvm_databinding_livedata_hieudn9.ViewModle.LoginViewModel
import gst.trainingcourse.mvvm_databinding_livedata_hieudn9.databinding.ActivityMainBinding
import java.util.*
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;


class MainActivity : AppCompatActivity() {
    private var loginViewModel: LoginViewModel? = null
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProviders.of().get<LoginViewModel>(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.setLoginViewModel(loginViewModel)
        loginViewModel!!.user!!.observe(this, object : Observer<LoginUser?>() {
            fun onChanged(@Nullable loginUser: LoginUser) {
                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                    binding.txtEmailAddress.setError("Enter an E-Mail Address")
                    binding.txtEmailAddress.requestFocus()
                } else if (!loginUser.isEmailValid) {
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address")
                    binding.txtEmailAddress.requestFocus()
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                    binding.txtPassword.setError("Enter a Password")
                    binding.txtPassword.requestFocus()
                } else if (!loginUser.isPasswordLengthGreaterThan5) {
                    binding.txtPassword.setError("Enter at least 6 Digit password")
                    binding.txtPassword.requestFocus()
                } else {
                    binding.lblEmailAnswer.setText(loginUser.strEmailAddress)
                    binding.lblPasswordAnswer.setText(loginUser.strPassword)
                }
            }
        })
    }
}