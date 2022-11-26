package gst.trainingcourse.bootupstart

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class StartUpOnBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(Intent.ACTION_BOOT_COMPLETED.equals(intent.action)){
            var ActivityIntent = Intent(context, MainActivity::class.java )
            ActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivities(arrayOf(ActivityIntent))
        }
    }
}