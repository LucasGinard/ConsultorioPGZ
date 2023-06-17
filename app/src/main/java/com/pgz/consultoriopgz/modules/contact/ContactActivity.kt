package com.pgz.consultoriopgz.modules.contact

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityContactBinding

class ContactActivity: AppCompatActivity() {

    private val REQUEST_CALL_PHONE_PERMISSION = 1
    lateinit var binding:ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureUI()
        configureOnClickListeners()
    }

    private fun configureUI(){
        binding.header.tvTitleHeader.text = "Contacto"
        binding.header.icLogo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_phone))
    }

    private fun configureOnClickListeners(){
        binding.header.btnArrowBack.setOnClickListener {
            finish()
        }

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

        binding.tvAsesor.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            val twitterUrl = "https://twitter.com"

            val packageManager = packageManager
            val twitterAppIntent = Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name="))
            val resolveInfo = packageManager.queryIntentActivities(twitterAppIntent, 0)

            if (resolveInfo.isNotEmpty()) {
                intent.data = Uri.parse(twitterUrl)
                intent.setPackage("com.twitter.android")
            } else {
                intent.data = Uri.parse(twitterUrl)
            }

            startActivity(intent)
        }
    }

    private fun requirePermissionForCall():Boolean{
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }

}