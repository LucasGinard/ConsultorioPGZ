package com.pgz.consultoriopgz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.pgz.consultoriopgz.databinding.ActivitySplashScreenBinding
import com.pgz.consultoriopgz.modules.home.MainActivity

class SplashScreenActivity: AppCompatActivity() {

    lateinit var binding:ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToHome()
    }

    private fun goToHome(){
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        }, 2000)
    }

}