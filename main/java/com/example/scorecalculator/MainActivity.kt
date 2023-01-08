package com.example.scorecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {




    lateinit var resScore : Button
    lateinit var homePlus : Button
    lateinit var homeMinus : Button
    lateinit var guestPlus : Button
    lateinit var guestMinus : Button
    lateinit var homeSc : TextView
    lateinit var guestSc : TextView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resScore = findViewById(R.id.resetScore)
        homePlus = findViewById(R.id.homePlusBtn)
        homeMinus = findViewById(R.id.homeMinusBtn)
        guestPlus = findViewById(R.id.guestPlusBtn)
        guestMinus = findViewById(R.id.guestMinusBtn)
        homeSc = findViewById(R.id.homeScore)
        guestSc = findViewById(R.id.guestScore)
        toolbar = findViewById(R.id.toolBar)


        toolbar.inflateMenu(R.menu.options)
        toolbar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.Share){

                val message = "Home score for this party is ${homeSc.text.toString()}, and guest score is ${guestSc.text.toString()}"

                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, message)

                if (shareIntent.resolveActivity(packageManager)!=null){
                    startActivity(shareIntent)
                }else{
                    Toast.makeText(this, "Wait a minute", Toast.LENGTH_SHORT ).show()
                }

            }else if (menuItem.itemId == R.id.Settings){
                Toast.makeText(this, "Wait a minute", Toast.LENGTH_SHORT ).show()
            }else if (menuItem.itemId == R.id.Color){
                Toast.makeText(this, "Wait to change your team color", Toast.LENGTH_SHORT).show()
            }
            true
        }



        //1ère méthode
        resScore.setOnClickListener {
            var contenuHome = homeSc.text.toString().toInt()
            var contenuGuest = guestSc.text.toString().toInt()

            contenuHome = 0
            contenuGuest = 0

            homeSc.text = contenuHome.toString()
            guestSc.text = contenuGuest.toString()

        }



        homePlus.setOnClickListener {
            var contenu = homeSc.text.toString().toInt()
            contenu = contenu + 1
            homeSc.text = contenu.toString()
        }

        homeMinus.setOnClickListener {
            var contenu = homeSc.text.toString().toInt()
            if (contenu>0){
            contenu = contenu - 1
            }
            homeSc.text = contenu.toString()

        }

        guestPlus.setOnClickListener {
            var contenu = guestSc.text.toString().toInt()
            contenu = contenu + 1
            guestSc.text = contenu.toString()
        }

        guestMinus.setOnClickListener {
            var contenu = guestSc.text.toString().toInt()
            if (contenu>0){
                contenu = contenu - 1
            }
            guestSc.text = contenu.toString()

        }



    }




}