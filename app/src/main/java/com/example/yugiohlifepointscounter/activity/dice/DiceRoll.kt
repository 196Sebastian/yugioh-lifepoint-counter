package com.example.yugiohlifepointscounter.activity.dice

class DiceRoll(private val numSides: Int) {

    fun roll(): Int{
        return(1..numSides).random()
    }

}