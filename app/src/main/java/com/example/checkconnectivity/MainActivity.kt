package com.example.checkconnectivity

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import com.example.checkconnectivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityLiveData: CnLiveData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkNetwork()


    }

    private fun checkNetwork(){

        connectivityLiveData = CnLiveData(application)
        connectivityLiveData.observe(this, { isAvailable ->

            when(isAvailable){
                true -> binding.txtConnection.text = "Have Internet Connection "
                false -> binding.txtConnection.text = "No Internet Connection"


            }


        })

    }

}