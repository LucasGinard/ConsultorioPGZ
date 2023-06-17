package com.pgz.consultoriopgz.modules.contact

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.pgz.consultoriopgz.databinding.ActivityContactBinding

class ContactActivity: AppCompatActivity() {

    private val REQUEST_CALL_PHONE_PERMISSION = 1
    lateinit var binding:ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureCallPhone()
        configureContactAdviser()
    }

    private fun configureCallPhone(){
        binding.tvPhone.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:${binding.tvPhone.text}")

            if (requirePermissionForCall()) {
                startActivity(callIntent)
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_CALL_PHONE_PERMISSION
                )
            }
        }
    }

    private fun requirePermissionForCall():Boolean{
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun configureContactAdviser(){

    }
}