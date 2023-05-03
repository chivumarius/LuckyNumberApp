package com.chivumarius.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        // ♦ STEP 2:  "DECLARATION & INITIALIZATION" OF "XML WIDGETS" ("SCREEN 2")
        val text1 : TextView = findViewById(R.id.text1) // ♦ import android.widget.TextView
        val luckyText: TextView  = findViewById(R.id.luckyNumTxt)
        val shareBtn: Button = findViewById(R.id.shareBtn)  // ♦ import android.widget.Button

        // ♦ STEP 3.1: Storing in "user_name" Variable
        //      → the "receiveUserName()" Method Calls:
        var user_name = receiveUserName()

        // ♦ STEP 3.2: Calling "generateRandomNum()" Method:
        var random_num = generateRandomNum()

        // ♦ Setting the "text" for "Lucky Text"
        luckyText.setText(""+random_num)

        // ♦ STEP 3.3: When the User Press "Share Button"
        shareBtn.setOnClickListener(){
            // ♦ Calling "shareData()" Method:
            shareData(user_name, random_num)
        }
    }

    // ♦ STEP 3.1: RECIEVING  "USERNAME" DATA → FROM  "MAIN ACTIVITY" ("SCREEN 1")
    fun receiveUserName():String{
        // ♦ Receiving Data from "Extras":
        var bundle: Bundle? = intent.extras

        // ♦ "Storing" the "Received Data":
        var username = bundle?.get("name").toString()  // ♦  "?" = "Any Type"

        // ♦ Returning the "Username" String:
        return username
    }

    // STEP 3.2: "RANDOM NUMBERS GENERATOR"
    fun generateRandomNum(): Int{
        // ♦ Getting "Random Numbers" between "0 - 1000":
        val random = Random.nextInt(1000)  // ♦ import kotlin.random.Random
        return random
    }


    // ♦ STEP 3.3: SHARING THE "USERNAME" & "LUCKY NUMBER":
    fun shareData(username: String, num : Int){
        // ♦ "IMPLICIT INTENT" (FOR "EXTERNAL SHARING DATA" WITH "OTHER APPS") ♦
        var i = Intent(Intent.ACTION_SEND)  // ♦ import android.content.Intent

        // ♦ Setting the "Text Type":
        i.setType("text/plain")

        // ♦ Setting "Data Subject" ("Title") for the "Email":
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today" )

        // ♦ Setting "Data Body Text" for the "Email":
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is $num" )

        // ♦ Calling the "startActivity()" Function:
        startActivity(i)
    }
}