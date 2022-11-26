package gst.trainingcourse.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class MySmsReceiver(private val iCallBack: ICallBack) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ProcessSms(context, intent)
        iCallBack.modifyText("Received")
        
    }

    private fun ProcessSms(context: Context, intent: Intent) {
        var MyBundle = intent.extras
        var Messenge: String = ""
        var Body : String = ""
        var Address : String = ""
        if(MyBundle != null){
            val MySms = arrayOf(MyBundle.get("pdus") as Any)
            for(i in 0 until MySms.size){
                var  sms : SmsMessage = SmsMessage.createFromPdu(MySms[i] as ByteArray?)
                Body += sms.messageBody// lay noi dung tin nhan
                Address = sms.originatingAddress.toString() // lay so dien thoai
                Messenge = "co mot tin nhan tu" + Address + " " + Body + " vua gui den"
                Toast.makeText(context, Messenge, Toast.LENGTH_LONG).show()

            }
        }
    }
}