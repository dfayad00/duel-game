package edu.temple.buttons

import android.widget.TextView
import java.lang.StringBuilder

fun getMoveList() : ArrayList<String> {
    val moves = ArrayList<String>()
    moves.add("Attack") //attack
    moves.add("Block") //block
    moves.add("Counter") //counter
    moves.add("Nothing") //nothing

    return moves
}

class Player(_health: Int, _healthBar: TextView) {
    var health = _health
    var maxHealth = _health
    private val healthBar = _healthBar

    fun getHealthBar() {
        health = maxHealth
        val sb = StringBuilder()
        for(i in 1..maxHealth) {
            sb.append("■")
        }
        healthBar.text = sb
    }

    private fun getHealthBar(healthBar: TextView){
        val sb = StringBuilder()
        for(i in 1..health) {
            sb.append("■")
        }
        healthBar.text = sb
    }

    fun getMove() : String {
        val moves = getMoveList()
        return moves.random()
    }

    fun doMove(opponent: Player, opponentMove: String, userMove: String): Int {
        when(userMove) {
            "Attack" -> {
                if(opponentMove != "Block" && opponentMove != "Counter") {
                    opponent.health--
                    opponent.getHealthBar(opponent.healthBar)
                }
            }
            "Counter" -> {
                if(opponentMove == "Attack") {
                    opponent.health -= 2
                    opponent.getHealthBar(opponent.healthBar)
                } else {
                    health--
                    getHealthBar(healthBar)
                }
            }
        }

        return opponent.health
    }
}