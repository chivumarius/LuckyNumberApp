package com.chivumarius.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ♦ STEP 2:  "DECLARATION & INITIALIZATION" OF "XML WIDGETS" ("SCREEN 1")
        val b1 : Button = findViewById(R.id.btn)    // ♦ import android.widget.Button
        val txt: TextView = findViewById(R.id.textView)     // ♦ import android.widget.TextView
        val editTXT: EditText = findViewById(R.id.editText)     // ♦ import android.widget.EditText

        // ♦ STEP 3: GETTING & PASSING "USERNAME" DATA → FROM  THE "USER" ("SCREEN 1":) → TO THE "LUCKNUMBERACTIVITY" ("SCREEN 2")
        b1.setOnClickListener(){
            // ♦ "Getting & Storing" the "Entered Name" from the "User":
            var username = editTXT.text

            // ♦ "EXPLICIT INTENTS" (FOR "PASSING DATA" → BETWEEN "ACTIVITIES")♦
            var i = Intent(this, LuckyNumberActivity::class.java )  // ♦ import android.content.Intent

            // ♦ "PASSING" → THE "USERNAME" DATA:
            i.putExtra("name", username)

            // ♦ Calling the "startActivity()" Method:
            startActivity(i)
        }
    }
}