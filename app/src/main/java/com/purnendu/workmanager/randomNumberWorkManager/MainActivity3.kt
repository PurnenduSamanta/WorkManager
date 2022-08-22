package com.purnendu.workmanager.randomNumberWorkManager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.work.Constraints
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.purnendu.workmanager.ui.theme.WorkManagerTheme
import java.util.concurrent.TimeUnit

class MainActivity3 : ComponentActivity() {


    private lateinit var workManager: WorkManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WorkManagerTheme {

                workManager = WorkManager.getInstance(applicationContext)

                val request = PeriodicWorkRequestBuilder<RandomNumberWorker>(1, TimeUnit.MINUTES)
                  //  .setInitialDelay(10, TimeUnit.MINUTES)
                    .setConstraints(
                        Constraints.Builder().setRequiresBatteryNotLow(true).build()
                    ).build()

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Button(onClick = {
                        workManager.enqueue(request)

                    }) {

                        Text(text = "Generate")

                    }

                }


            }
        }

    }
}