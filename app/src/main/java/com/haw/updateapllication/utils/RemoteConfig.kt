package com.haw.updateapllication.utils

import android.util.Log
import com.google.firebase.BuildConfig
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.get
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.haw.updateapllication.R

object RemoteConfig {

    private val TAG = RemoteConfig::class.java.simpleName
    private const val VERSION_APP = "version_app"

    private val remoteConfig: FirebaseRemoteConfig by lazy { Firebase.remoteConfig }

    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        remoteConfig.addOnConfigUpdateListener(object : ConfigUpdateListener {
            override fun onUpdate(configUpdate: ConfigUpdate) {
                Log.d(TAG, "onUpdate: ${remoteConfig.activate().result}")
            }

            override fun onError(error: FirebaseRemoteConfigException) {
                Log.w(TAG, "Config update error with code: " + error.code, error)
            }
        })
    }

    fun getUpdateApp(): Boolean {
        return remoteConfig[VERSION_APP].asDouble() > BuildConfig.VERSION_NAME.toDouble()
    }

}