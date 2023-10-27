package com.co.edu.udea.compumovil.gr06_2023_2.lab2.workers

import android.content.Context
import android.util.Log
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

class NotificationsWorker(private val appContext: Context, workerParameters: WorkerParameters) : Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        Log.i("worker started", ":D")
        NotificationHandler.createReminderNotification(appContext)

        return Result.success()
    }

    companion object {
        fun start(appContext: Context) {
            val subscriptionNotificationWork = PeriodicWorkRequestBuilder<NotificationsWorker>(15, TimeUnit.MINUTES)
                .setInitialDelay(15, TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(appContext)
                .enqueueUniquePeriodicWork(
                    "subscription_notification_work",
                    ExistingPeriodicWorkPolicy.UPDATE,
                    subscriptionNotificationWork
                )
        }
    }

}