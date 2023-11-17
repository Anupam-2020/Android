package com.example.notificationdemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private val channelID = "com.example.notificationdemo.channel1"
    private var notificationManager: NotificationManager? = null

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            createNotificationChannel(channelID, "Notification Demo", "This is notification description")
        button = findViewById(R.id.button)

            button.setOnClickListener {
                displayNotification()
            }
    }

    private fun displayNotification() {
        val notificationId = 45
        val notification = NotificationCompat.Builder(this@MainActivity, channelID)
            .setContentTitle("Demo Title")
            .setContentText("Notification by Anupam")
            .setSmallIcon(R.drawable.ic_stat_name)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager?.notify(notificationId ,notification)
    }

    private fun createNotificationChannel(id: String, name: String, channelDesc: String) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelID, name, importance).apply {
                description = channelDesc
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }
}