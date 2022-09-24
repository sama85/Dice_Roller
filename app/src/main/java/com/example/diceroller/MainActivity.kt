package com.example.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // declare binding object as property of main activity
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialize binding object with static inflate method
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                rollDice()
            }
        })
    }

    private fun rollDice() {
        val randomInt = Random.Default.nextInt(6) + 1

        val drawableRes = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImg.setImageResource(drawableRes)

        /* getting drawable from resource and using set image drawable
        val res = AppCompatResources.getDrawable(applicationContext, drawableRes)
        diceImg.setImageDrawable(res)
        */

    }
}