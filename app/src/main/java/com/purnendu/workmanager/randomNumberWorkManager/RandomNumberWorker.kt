package com.purnendu.workmanager.randomNumberWorkManager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.purnendu.workmanager.R
import kotlin.random.Random

class RandomNumberWorker(private val context: Context,private val workerParameters: WorkerParameters) :Worker(context,workerParameters) {
    override  fun doWork(): Result {
        val random=Random.nextInt()*10
        showNotification("Generating Random number",random.toString())
       return Result.success()
    }


    private  fun showNotification(task: String, desc: String) {

        val manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        val channelId = "message_channel"
        val channelName = "message_name"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName,
                NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle(task)
            .setContentText(desc)
            .setSmallIcon(R.drawable.ic_launcher_background)

        manager.notify(1, builder.build())
    }

}