package gst.trainingcourse.mvvm_databinding_livedata_hieudn9.ViewModle

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import gst.trainingcourse.mvvm_databinding_livedata_hieudn9.Model.LoginUser



class LoginViewModel : ViewModel() {
    var EmailAddress: MutableLiveData<String> = MutableLiveData()
    var Password: MutableLiveData<String> = MutableLiveData()
    private var userMutableLiveData: MutableLiveData<LoginUser>? = null
    fun getUser() :MutableLiveData<LoginUser> {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData as MutableLiveData<LoginUser>
        }

    fun onClick(view: View?) {
        val loginUser = LoginUser(EmailAddress.getValue().toString(), Password.getValue().toString())
        this.userMutableLiveData?.setValue(loginUser)
    }
}