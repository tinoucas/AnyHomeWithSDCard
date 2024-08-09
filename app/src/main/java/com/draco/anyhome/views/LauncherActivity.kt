package com.draco.anyhome.views

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Environment
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.draco.anyhome.viewmodels.LauncherActivityViewModel


class LauncherActivity : AppCompatActivity() {
    private val viewModel: LauncherActivityViewModel by viewModels()

    private fun startActivityIfStorageMounted() {
        val state = Environment.getExternalStorageState()

        if (Environment.MEDIA_MOUNTED == state && viewModel.isHomeAppSet()) {
            viewModel.homeAppIntent?.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(viewModel.homeAppIntent)
            overridePendingTransition(0, 0)
        }
    }

    override fun onResume() {
        super.onResume()
        if (!viewModel.isHomeAppSet()) {
            val intent = Intent(this, SelectActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)

            return
        }
        val externalStorageStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                Thread.sleep(1000)
                startActivityIfStorageMounted()
            }
        }
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_MEDIA_MOUNTED)
        filter.addDataScheme("file");
        registerReceiver(externalStorageStateReceiver, filter)
        startActivityIfStorageMounted()
    }
}
