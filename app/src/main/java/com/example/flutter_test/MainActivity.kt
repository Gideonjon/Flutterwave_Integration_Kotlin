package com.example.flutter_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.flutterwave.raveandroid.RaveConstants
import com.flutterwave.raveandroid.RavePayActivity
import com.flutterwave.raveandroid.RavePayManager
import java.security.PublicKey

class MainActivity : AppCompatActivity() {

    private lateinit var btn_pay: Button
    private var PublicKey = "FLWPUBK_TEST-06fe0b1c5d0e3af287d0ec5c99dec6f0-X"
    private var EncryptionKey = "FLWSECK_TESTf5dca3a1293a"
    private var narration = "Transfer Money"
    private var email = "gideonjones63@gmail.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        btn_pay = findViewById(R.id.pay)



        btn_pay.setOnClickListener {
            makepayment()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
            val message = data.getStringExtra("response")
        }


    }

    private fun makepayment() {
        RavePayManager(this)
            .setEmail(email)
            .setCountry("NGN")
            .setCurrency("NGN")
            .setAmount(Double.NaN)
            .setfName("Licio")
            .setlName("Lentimo")
            .setNarration(narration)
            .setPublicKey(PublicKey)
            .setEncryptionKey(EncryptionKey)
            .setTxRef(System.currentTimeMillis().toString() + "Ref")
            .acceptAccountPayments(true)
            .acceptCardPayments(true)
            .acceptMpesaPayments(true)
            .onStagingEnv(true)
            .shouldDisplayFee(true)
            .showStagingLabel(true)
            .acceptMpesaPayments(true)
            .acceptSaBankPayments(true)
            .acceptUssdPayments(true)
            .acceptGHMobileMoneyPayments(true)
            .acceptBankTransferPayments(true)
            .allowSaveCardFeature(true)
            .withTheme(com.flutterwave.raveandroid.R.style.DefaultTheme)
            .initialize()
    }




}


