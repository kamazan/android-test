package com.evaneos.evaneostest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evaneos.destinations_list.navigation.DestinationsListActions
import com.evaneos.evaneostest.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}