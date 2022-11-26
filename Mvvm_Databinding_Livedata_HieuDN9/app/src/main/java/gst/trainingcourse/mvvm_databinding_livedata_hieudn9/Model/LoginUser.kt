package gst.trainingcourse.mvvm_databinding_livedata_hieudn9.Model

import android.util.Patterns


class LoginUser (val strEmailAddress: String, val strPassword: String) {

    fun isEmailValid(): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(strEmailAddress).matches()
    }
    fun isPasswordLengthGreaterThan5(): Boolean{
        return strPassword.length > 5
    }
}